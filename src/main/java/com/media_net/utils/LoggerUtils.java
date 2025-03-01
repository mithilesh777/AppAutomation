package com.media_net.utils;

import com.media_net.base.BaseTest;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author mithilesh.singh
 * LoggerUtils will help to create logger mechanism using log4j to provide inbuild methodes to log the steps.
 */

public class LoggerUtils {
    public static org.apache.log4j.Logger getLogger(String tagName) {
        PropertyConfigurator.configure(BaseTest.class.getClassLoader().getResourceAsStream("log4j.properties"));
        return Logger.getLogger(tagName);
    }
}