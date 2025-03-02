package com.media_net.pages;

import com.media_net.driver.DriverManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author mithilesh.singh
 */


public class ToDoPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/note_title']")
    private WebElement titleText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/btn_save']")
    private WebElement saveOption;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/edit_text_id']")
    private WebElement toDoPara;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/btn_color_change']")
    private WebElement changeBackGroundColorOption;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/title']/..//android.view.ViewGroup)[2]")
    private WebElement backgroundColorOptionIcon;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.notes.todolist.notebook.checklist.notepad.android.dev:id/design_bottom_sheet']")
    private WebElement changeBackgroundPopUpFrame;


// ====================================================================================================================================


    public ToDoPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

    public void verifyToDoPage() {
        wait.until(ExpectedConditions.visibilityOf(saveOption));
    }

    public void clickOnSave() {
        saveOption.click();
    }

    public void enterToDoTitle(String todoTitle) {
        titleText.sendKeys(todoTitle);
    }

    public void enterToDoPara(String todoPara) {
        toDoPara.sendKeys(todoPara);
    }

    public void clickOnChangeColorOption(){
        changeBackGroundColorOption.click();
    }

    public void chooseBackGroundColor() {
        waitForElementVisibility(backgroundColorOptionIcon);
//        jumpToFrameById(changeBackgroundPopUpFrame);
        backgroundColorOptionIcon.click();
        hideKeyboard();
//        backToDefaultFrame();
    }
}
