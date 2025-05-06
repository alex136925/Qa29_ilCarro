package tests;

import org.testng.annotations.Test;

import static tests.TestBase.app;

public class LoginTests {


    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("mara1@gmail.com", "Roma3456$");
        app.getHelperUser().submitLogin();
    }
}
