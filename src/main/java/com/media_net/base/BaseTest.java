package com.media_net.base;

import com.media_net.pages.HomePage;
import com.media_net.pages.NoteLauncherPage;
import com.media_net.pages.NotePage;
import com.media_net.pages.ToDoPage;
import com.media_net.utils.AppiumServer;
import com.media_net.utils.ApplicationException;
import com.media_net.utils.Config;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import static com.media_net.driver.Driver.initDriver;
import static com.media_net.driver.DriverManager.flush;
import static com.media_net.driver.DriverManager.getDriver;

/**
 * @author mithilesh.singh
 * This class will act like a parent class for all the Test class, it will help to start the appium server
 * and initialise the thread safe driver.
 */


public class BaseTest {
    protected AppiumServer appiumServer;
    public HomePage homePage;
    public NoteLauncherPage noteLauncherPage;
    public NotePage notePage;
    public ToDoPage toDoPage;
    public Config config;


    // Method to start Appium server and initialize the driver
    @BeforeClass(alwaysRun = true)
    public void setUp() throws IOException, ApplicationException {
        config = new Config(System.getProperty("user.dir") + "/src/resources/config.properties");

        // Start Appium server
        appiumServer = new AppiumServer();

        appiumServer.startAppiumServer();

        //helper method to initialise the Thread safe driver
        initDriver();
    }

    // Stop the Appium server and quit the driver
    @AfterClass
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            flush();
        }
        // Stop Appium server after test execution
        if (appiumServer != null) {
            appiumServer.stopAppiumServer();
        }
    }
}
