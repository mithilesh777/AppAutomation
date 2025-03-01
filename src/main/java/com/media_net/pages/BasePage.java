package com.media_net.pages;

import com.media_net.driver.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author mithilesh.singh
 * This base will contain all the common actions method which will support page object classes to reduce the repeated code
 */


public class BasePage {

    public BasePage() {
    }

    static WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

    public static boolean waitForElementVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    public void hideKeyboard() {
        if (((AndroidDriver) DriverManager.getDriver()).isKeyboardShown()) {
            ((AndroidDriver) DriverManager.getDriver()).hideKeyboard();
        }
    }

    public void jumpToFrameById(WebElement element) {
        DriverManager.getDriver().switchTo().frame(element);
    }

    public void backToDefaultFrame() {
        DriverManager.getDriver().switchTo().defaultContent();
    }
}
