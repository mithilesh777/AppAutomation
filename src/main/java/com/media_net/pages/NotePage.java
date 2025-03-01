package com.media_net.pages;

import com.media_net.driver.DriverManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static com.media_net.pages.BasePage.waitForElementVisibility;

/**
 * @author mithilesh.singh
 */

public class NotePage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/btn_save']")
    private WebElement saveOption;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/note_title']")
    private WebElement titleBox;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='editor']")
    private WebElement noteBox;


// ====================================================================================================================================



    public NotePage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    public void clickOnSave() {
        waitForElementVisibility(saveOption);
        saveOption.click();
    }

    public void enterTitleOfNote(String noteTitle) {
        titleBox.sendKeys(noteTitle);
    }

    public void enterNotePara(String notePara) {
        noteBox.click();
        noteBox.sendKeys(notePara);
    }
}