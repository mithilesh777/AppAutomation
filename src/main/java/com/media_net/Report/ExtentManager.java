package com.media_net.Report;

import com.aventstack.extentreports.ExtentTest;

/**
 * @author mithilesh.singh
 * Extent Manger will help to keep our Extent report clean and readable, it will mainly help in parallel exection to maintain the report thread wise
 */


public class ExtentManager {

    private ExtentManager() {}

    private static ThreadLocal<ExtentTest> test = new ThreadLocal();

    public static ExtentTest getExtentTestInstance() {
        return test.get();
    }

    public static void setExtentTest(ExtentTest extentTest) {
        test.set(extentTest);
    }

    public static void remove() {
        test.remove();
    }
}


