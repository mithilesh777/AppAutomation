package com.media_net.utils;

import com.media_net.Report.ExtentReport;
import com.media_net.Report.ReportLogger;
import com.media_net.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * @author mithilesh.singh
 * This TestNg Listner will pass the log message to the report based on specific events which will create more readable report.
 * It willbe helpful in debugging the failures
 */

public class Listeners implements ITestListener, ISuiteListener {

    public void onStart(ITestContext result) {
        ExtentReport.setUpReport();
    }

    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        ReportLogger.pass(result.getName() + "is passed");
    }

    public void onTestFailure(ITestResult result) {
        ReportLogger.fail(result.getName() + "is failed");
        ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }

    public void onTestSkipped(ITestResult result) {
        ReportLogger.skip(result.getName() + "is skipped");
    }

    public void onFinish(ITestContext result) {
        ExtentReport.tearDownReport();
    }
}