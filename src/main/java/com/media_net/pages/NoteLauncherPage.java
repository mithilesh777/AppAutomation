package com.media_net.pages;

import com.media_net.driver.DriverManager;
import com.media_net.utils.ApplicationException;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * @author mithilesh.singh
 */

public class NoteLauncherPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/btn_create_note']")
    private WebElement plusIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/label_todo_note']")
    private WebElement createToDoListOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/label_text_note']")
    private WebElement createTextNoteOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/notes_title_view']")
    private WebElement pageTitle;

    /*
    As of now i am assuming one one note or todolist item hence writing xpath like this but to validate
    title and content dynamically we can get the count of all matching elements and iterate over total values and check the
     actual match with dynamic xpath, due to time limitation as of now no going in that approach
     */


    @AndroidFindBy(xpath = "((//android.widget.LinearLayout[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/note_content_preview'])[1]//android.widget.TextView)[1]")
    private WebElement createdNotesVerification;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/container']/android.view.ViewGroup/android.widget.TextView[1])[1]")
    private WebElement createdToDoListVerification;


// ====================================================================================================================================





    public NoteLauncherPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    public void clickOnPlusIcon() {
        plusIcon.click();
    }

    public void clickOnCreateToDoList() {
        createToDoListOption.click();
    }

    public void clickOnCreateATextNote() {
        createTextNoteOption.click();
    }

    public void verifyMyNotesPageTitle() throws ApplicationException {
        if (waitForElementVisibility(pageTitle))
            Assert.assertEquals(pageTitle, "My Notes", "Page title is not visible");
        else {
            throw new ApplicationException("verifyCreatedNoteTitle", "Title is not visible");
        }
    }

    public void createdNotesValidation() {
        Assert.assertEquals(createdNotesVerification.getText(), "Note 1", "note has not been created");
    }

    public void createdToDoValidation() {
        Assert.assertEquals(createdToDoListVerification.getText(), "My ToDo List", "todo list has not been created");
    }
}