package com.media_net.pages;

import com.media_net.driver.DriverManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * @author mithilesh.singh
 */

public class HomePage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/btn']")
    private WebElement getStartedButton;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='android:id/title'])[1]")
    private WebElement noteLauncherTextView;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/left_arrow']")
    private WebElement notesAndToDoInitiatorArrow;


// ====================================================================================================================================


    public HomePage() {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    public void clickOnGetStarted() {
        getStartedButton.click();
    }

    public void clickOnNotesLauncherOption() {
        noteLauncherTextView.click();
    }

    public void clickOnNoteAndToDoInitiatorArrow() {
        waitForElementVisibility(notesAndToDoInitiatorArrow);
        notesAndToDoInitiatorArrow.click();
    }
}