package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{
    public void preCondition(){
        if (app.getHelperUser().isLogged()){
            app.getHelperUser().signOut();
        }
    }

    @Test
    public void registrationSuccess(){
        int i = new Random().nextInt(1000)+1000;
        int z = (int) (System.currentTimeMillis()/1000%3600);

        User user = new User()
                .setFirstName("Lisa")
                .setLastName("Jackson")
                .setEmail("snow" + z + "@gmail.com")
                .setPassword("SsnowJ$59");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("You are logged in success"));
    }

}
