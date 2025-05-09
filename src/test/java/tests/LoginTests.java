package tests;

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
            app.getHelperUser().signOut(); // or refresh if no sign-out
            app.getHelperUser().openLoginForm();
        }
    }



    @Test
    public void testLoginSuccess(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("tipsytutor92@gmail.com", "West1234$");
        app.getHelperUser().submitLogin();
        //Assert if element with text "login Success" is present OK
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Logged in success"));
        app.getHelperUser().clickOkButton();

    }


    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testLoginWrongEmail(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("tipsytutor92gmail.com", "West1234$");
        app.getHelperUser().submitLogin();
        Assert.assertEquals(app.getHelperUser().getFailMessage(), "It'snot look like email");

    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testLoginWrongPassword(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("tipsytutor@92gmail.com", "West1");
        app.getHelperUser().submitLogin();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        app.getHelperUser().clickOkButton();

    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testUnregisteredUser(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("tipsy@gmail.com", "West1234$");
        app.getHelperUser().submitLogin();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        app.getHelperUser().clickOkButton();

    }




}
