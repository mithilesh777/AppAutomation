package com.media_net.Report;

/**
 * @author mithilesh.singh
 * This will help to log your customise messages in extent report
 */
public class ReportLogger {
    private ReportLogger() {
    }

    public static void pass(String msg) {
        ExtentManager.getExtentTestInstance().pass(msg);
    }

    public static void fail(String msg) {
        ExtentManager.getExtentTestInstance().fail(msg);
    }

    public static void info(String msg) {
        ExtentManager.getExtentTestInstance().info(msg);
    }

    public static void skip(String msg) {
        ExtentManager.getExtentTestInstance().skip(msg);
    }
}