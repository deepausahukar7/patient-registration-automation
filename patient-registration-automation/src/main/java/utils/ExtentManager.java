package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentReports extent;

    public static ExtentReports getReport() {

        if (extent == null) {

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter("reports/ExtentReport.html");

            reporter.config().setReportName("Patient Registration Automation");
            reporter.config().setDocumentTitle("Automation Test Report");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }
}
