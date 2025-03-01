package com.media_net.tests;

import com.media_net.Report.ReportLogger;
import com.media_net.base.BaseTest;
import com.media_net.pages.*;
import com.media_net.utils.ApplicationException;
import com.media_net.utils.Config;
import com.media_net.utils.LoggerUtils;
import org.testng.annotations.Test;

/**
 * @author mithilesh.singh
 * Test Class to maintain all the test cases in terms of test method.
 */


public class RegressionTest extends BaseTest {

    String tagName = RegressionTest.class.getName();

    @Test(priority = 1, description = "Test case 1: Onboarding Test")
    public void onBoardingTest() throws ApplicationException {
        LoggerUtils.getLogger(tagName).info(" -> on boarding Test case : started");
        homePage = new HomePage();
        homePage.clickOnGetStarted();
        ReportLogger.info("clicked on the Get Started button");
        homePage.clickOnNotesLauncherOption();
        homePage.clickOnNoteAndToDoInitiatorArrow();
        noteLauncherPage = new NoteLauncherPage();
        noteLauncherPage.verifyMyNotesPageTitle();
        LoggerUtils.getLogger(tagName).info(" -> on boarding Test case : completed");
    }

    @Test(priority = 2, description = "Test case 2: Creating a Test Node")
    public void textNodeCreationTest() throws ApplicationException {
        LoggerUtils.getLogger(tagName).info(" -> textNodeCreationTest : started");
        noteLauncherPage = new NoteLauncherPage();
        noteLauncherPage.clickOnPlusIcon();
        ReportLogger.info("clicked on the + icon");
        noteLauncherPage.clickOnCreateATextNote();
        noteLauncherPage.hideKeyboard();
        notePage = new NotePage();
        notePage.enterTitleOfNote(config.getProperty("notes.title"));
        notePage.hideKeyboard();
        notePage.enterNotePara(config.getProperty("notes.para"));
        notePage.hideKeyboard();
        notePage.clickOnSave();
        ReportLogger.info("clicked on the save button");
        noteLauncherPage.verifyMyNotesPageTitle();
        noteLauncherPage.createdNotesValidation();
        LoggerUtils.getLogger(tagName).info(" -> textNodeCreationTest : completed");
    }

    @Test(priority = 3, description = "Test case 3: Creating a To-Do List")
    public void toDoListCreationTest() throws ApplicationException {
        LoggerUtils.getLogger(tagName).info(" -> toDoListCreationTest : started");
        noteLauncherPage = new NoteLauncherPage();
        noteLauncherPage.clickOnPlusIcon();
        ReportLogger.info("clicked on the + icon");
        noteLauncherPage.clickOnCreateToDoList();
        toDoPage = new ToDoPage();
        toDoPage.hideKeyboard();
        toDoPage.verifyToDoPage();
        toDoPage.enterToDoTitle(config.getProperty("todo.title"));
        toDoPage.hideKeyboard();
        toDoPage.enterToDoPara(config.getProperty("todo.para"));
        toDoPage.clickOnChangeColorOption();
        toDoPage.chooseBackGroundColor();
        toDoPage.clickOnSave();
        ReportLogger.info("clicked on the save button");
        noteLauncherPage.verifyMyNotesPageTitle();
        noteLauncherPage.createdToDoValidation();
        LoggerUtils.getLogger(tagName).info(" -> toDoListCreationTest : completed");
    }
}