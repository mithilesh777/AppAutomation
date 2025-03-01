package com.media_net.driver;

import io.appium.java_client.AppiumDriver;

/**
 * @author mithilesh.singh
 * This class will help to create thread safe driver which mainly helps in paralle test execution.
 * It mainly contained get and set methos for driver and flush method to close the instance.
 */
public class DriverManager {
    private DriverManager() {
    }

    private static ThreadLocal<AppiumDriver> localDriver = new ThreadLocal<>();

    public static AppiumDriver getDriver() {
        return localDriver.get();
    }

    public static void setLocalDriver(AppiumDriver driver) {
        localDriver.set(driver);
    }

    public static void flush() {
        localDriver.remove();
    }
}
