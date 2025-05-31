package tests;

import models.User;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static tests.TestBase.app;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void ensureLoginFormIsOpen() {
        if (!app.getHelperUser().isLoginFormPresent()) {
            app.getHelperUser().signOut();
            app.getHelperUser().openLoginForm();
        }
    }



    @Test
    public void testLoginSuccessModel(){
        User user = new User().setEmail("tipsytutor92@gmail.com").setPassword("West1234$");
//        user.setEmail("tipsytutor92@gmail.com");
//        user.setPassword("West1234$");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        //Assert if element with text "login Success" is present OK
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Logged in success"));
        logger.info("Test data --> email: tipsytutor92@gmail.com & password: West1234$ ");
        app.getHelperUser().clickOkButton();

    }


    @Test
    public void testLoginSuccess(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("tipsytutor92@gmail.com", "West1234$");
        app.getHelperUser().submit();
        //Assert if element with text "login Success" is present OK
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Logged in success"));
        logger.info("Test data --> email: tipsytutor92@gmail.com & password: West1234$ ");
        app.getHelperUser().clickOkButton();

    }


    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testLoginWrongEmail(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("tipsytutor92gmail.com", "West1234$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getFailMessage(), "It'snot look like email");
        logger.info("Test data --> email: tipsytutor92gmail.com & password: West1234$ ");

    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testLoginWrongPassword(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("tipsytutor@92gmail.com", "West1");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        logger.info("Test data --> email: tipsytutor92@gmail.com & password: West1");
        app.getHelperUser().clickOkButton();

    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testUnregisteredUser(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("tipsy@gmail.com", "West1234$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        logger.info("Test data --> email: tipsy@gmail.com & password: West1234$ ");
        app.getHelperUser().clickOkButton();

    }




}
