package tests;

import org.testng.Assert;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;
import base.BaseTest;
import pages.PatientRegistrationPage;
import utils.ExcelUtils;
import utils.ExtentManager;

public class PatientRegistrationTest extends BaseTest {

    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void startReport() {
        extent = ExtentManager.getReport();
    }

    // ✅ DATA PROVIDER (EXCEL)
    @DataProvider(name = "patientData")
    public Object[][] getData() {
        return ExcelUtils.getExcelData(
            "TestData.xlsx",   // 👈 ONLY FILE NAME
            "PatientData"
        );
    }



    // ✅ DATA-DRIVEN TEST
    @Test(dataProvider = "patientData")
    public void verifyPatientRegistration(
            String name,
            String age,
            String mobile) throws Exception {

        test = extent.createTest(
            "Patient Registration : " + name
        );

        PatientRegistrationPage page =
                new PatientRegistrationPage(driver);

        page.registerPatient(name, age, mobile);

        Thread.sleep(500); // allow JS message to render

        Assert.assertTrue(
            page.getMessage().contains("Patient"),
            "Registration message not displayed"
        );


        test.pass("Patient registration successful");
    }

    @AfterMethod
    public void attachScreenshot() throws Exception {
        String screenshotPath =
                captureScreenshot("PatientRegistrationTest");

        test.addScreenCaptureFromPath(screenshotPath);
    }

    @AfterTest
    public void endReport() {
        extent.flush();
    }
}
