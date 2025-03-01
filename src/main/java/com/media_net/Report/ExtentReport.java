package com.media_net.Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.Objects;

/**
 * @author mithilesh.singh
 * ExtentReport class will help to generate execution report in customise form, we can set the report theme, name and title very easily
 * To log each step of test method we have testNode wich i have created in createTest method.
 * each testNode is set to specific Extent Manager to maintain the unique copy of execution.
 */


public class ExtentReport {

    public static ExtentReports extent;
    public static ExtentSparkReporter reporterAgent;
    public static ExtentTest testNode;

    public static void setUpReport() {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            reporterAgent = new ExtentSparkReporter("target/report/extent.html");
            reporterAgent.config().setReportName("App Automation Report");
            reporterAgent.config().setDocumentTitle("Extent_Report");
            reporterAgent.config().setTheme(Theme.DARK);
            extent.attachReporter(reporterAgent);
        }
    }

    public static void createTest(String testCaseName) {
        testNode = extent.createTest(testCaseName);
        ExtentManager.setExtentTest(testNode);
    }

    public static void tearDownReport() {
        if (Objects.isNull(extent)) {
            extent.flush();
            ExtentManager.remove();
        }
    }
}