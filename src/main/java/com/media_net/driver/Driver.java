package com.media_net.driver;

import com.media_net.utils.Config;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import static com.media_net.driver.DriverManager.setLocalDriver;

/**
 * @author mithilesh.singh
 * This Helper class with initialise the driver instance and set it in threadlocal.
 */
public class Driver {
    protected static AppiumDriver driver;

    //Singleton Pattern: Ensures only one instance of a class is created
    private Driver() {
    }

    // Initialise the driver instance and set it as local driver
    public static void initDriver() throws MalformedURLException {
        // Load properties for configurationx
        Config config = new Config(System.getProperty("user.dir") + "/src/resources/config.properties");
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(config.getProperty("device.name"))
                .setPlatformVersion(config.getProperty("platform.version"))
                .setPlatformName(config.getProperty("platform.name"))
                .setApp(config.getProperty(config.getProperty("apk.path")))
                .setRemoteAdbHost("127.0.0.1")
                .setAppWaitForLaunch(false)
                .setAdbExecTimeout(Duration.ofMinutes(3))
                .setUiautomator2ServerInstallTimeout(Duration.ofSeconds(40))
                .setNoReset(true);
        // Set up Appium server URL
        URL appiumServerUrl = new URL(config.getProperty("appium.server.url"));
        // Initialize the Appium driver
        // driver = new AndroidDriver(appiumServerUrl, options);
        setLocalDriver(new AndroidDriver(appiumServerUrl, options));
    }
}
