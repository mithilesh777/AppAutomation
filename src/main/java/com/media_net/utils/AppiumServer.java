package com.media_net.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;

/**
 * @author mithilesh.singh
 * This class with start and stop the appium server programatically
 */
public class AppiumServer {

    private static AppiumDriverLocalService service;

    // Method to start Appium server
    public void startAppiumServer() throws ApplicationException {
        getServerInstance().start();
    }

    public static void setDriverInstance() throws ApplicationException {
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"));
        builder.usingDriverExecutable(new File("/usr/local/bin/node"));
        builder.usingPort(4723);
        builder.withArgument(GeneralServerFlag.LOCAL_TIMEZONE);
        builder.withLogFile(new File("AppiumLog.txt"));
        builder.withIPAddress("127.0.0.1");
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
        LoggerUtils.getLogger("setDriverInstance").info(service.getUrl());
        LoggerUtils.getLogger("setDriverInstance").info(service.isRunning());
        LoggerUtils.getLogger("setDriverInstance").info("Appium server started");
    }

    public static AppiumDriverLocalService getServerInstance() throws ApplicationException {
        if (service == null) {
            setDriverInstance();
        }
        return service;
    }

    // Method to stop Appium server
    public void stopAppiumServer() {
        if (service != null && service.isRunning()) {
            service.stop();
            System.out.println("Appium server stopped");
        }
    }
}