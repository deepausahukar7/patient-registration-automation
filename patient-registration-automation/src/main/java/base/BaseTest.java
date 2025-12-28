package base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(
        	    java.time.Duration.ofSeconds(5)
        	);


        driver.get("file:///C:/New%20folder/patient-registration-ui/register.html");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    public String captureScreenshot(String testName) throws IOException {

        File src = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        String path = "report/screenshots/" + testName + ".png";

        FileUtils.copyFile(src, new File(path));

        return path;
    }
    
}

