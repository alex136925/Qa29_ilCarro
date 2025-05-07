package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static tests.TestBase.app;

public class LoginTests extends TestBase{


    @Test
    public void testLoginSuccess(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("tipsytutor92@gmail.com", "West1234$");
        app.getHelperUser().submitLogin();
        //Assert if element with text "login Success" is present OK
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        //app.getHelperUser().clickOkButton();

    }
}
