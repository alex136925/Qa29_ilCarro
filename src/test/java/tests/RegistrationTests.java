package tests;

import models.User;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if (app.getHelperUser().isLogged()){
            app.getHelperUser().signOut();
        }
    }

    @Test(enabled = false)
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
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("You are logged in success"));
        app.getHelperUser().clickOkButton();
        app.getHelperUser().signOut();
    }

    @Test(enabled = false)
    public void registrationWrongEmail(){
        int z = (int) (System.currentTimeMillis()/1000%3600);

        User user = new User()
                .setFirstName("Henry")
                .setLastName("Cooper")
                .setEmail("cooper" + z + "gmail.com")
                .setPassword("Cooper$18");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isEmailAlertPresent("Wrong email format"));

    }

    @Test(enabled = false)
    public void registrationWrongPasswordLessThan8(){
        int z = (int) (System.currentTimeMillis()/1000%3600);

        User user = new User()
                .setFirstName("Henry")
                .setLastName("Cooper")
                .setEmail("cooper" + z + "@gmail.com")
                .setPassword("Coo$18");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isPasswordAlertPresent("Password must contain minimum 8 symbols"));
    }

    @Test(enabled = false)
    public void registrationWrongPasswordNoUpperCase(){
        int z = (int) (System.currentTimeMillis()/1000%3600);

        User user = new User()
                .setFirstName("Henry")
                .setLastName("Cooper")
                .setEmail("cooper" + z + "@gmail.com")
                .setPassword("cooper$18");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isPasswordAlertPresent("Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]"));

    }

    @Test(enabled = false)
    public void registrationWrongPasswordNoLowerCase(){
        int z = (int) (System.currentTimeMillis()/1000%3600);

        User user = new User()
                .setFirstName("Henry")
                .setLastName("Cooper")
                .setEmail("cooper" + z + "@gmail.com")
                .setPassword("COOPER$18");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isPasswordAlertPresent("Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]"));

    }

    @Test(enabled = false)
    public void registrationWrongPasswordNoNumber(){
        int z = (int) (System.currentTimeMillis()/1000%3600);

        User user = new User()
                .setFirstName("Henry")
                .setLastName("Cooper")
                .setEmail("cooper" + z + "@gmail.com")
                .setPassword("Cooperwest$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isPasswordAlertPresent("Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]"));

    }

    @Test(enabled = false)
    public void registrationWrongPasswordNoSpecial(){
        int z = (int) (System.currentTimeMillis()/1000%3600);

        User user = new User()
                .setFirstName("Henry")
                .setLastName("Cooper")
                .setEmail("cooper" + z + "@gmail.com")
                .setPassword("Cooperwest18");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isPasswordAlertPresent("Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]"));

    }

    @Test(enabled = false)
    public void registrationWrongEmailWrongPasswordLessThan8(){
        int z = (int) (System.currentTimeMillis()/1000%3600);

        User user = new User()
                .setFirstName("Henry")
                .setLastName("Cooper")
                .setEmail("cooper" + z + "gmail.com")
                .setPassword("Coo$18");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isEmailAlertPresent("Wrong email format"));
        Assert.assertTrue(app.getHelperUser().isPasswordAlertPresent("Password must contain minimum 8 symbols"));
    }

    @Test(enabled = false)
    public void registrationWrongEmailWrongPasswordNoUpperCase(){
        int z = (int) (System.currentTimeMillis()/1000%3600);

        User user = new User()
                .setFirstName("Henry")
                .setLastName("Cooper")
                .setEmail("cooper" + z + "gmail.com")
                .setPassword("cooper$18");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isEmailAlertPresent("Wrong email format"));
        Assert.assertTrue(app.getHelperUser().isPasswordAlertPresent("Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]"));

    }

    @Test(enabled = false)
    public void registrationWrongEmailWrongPasswordNoLowerCase(){
        int z = (int) (System.currentTimeMillis()/1000%3600);

        User user = new User()
                .setFirstName("Henry")
                .setLastName("Cooper")
                .setEmail("cooper" + z + "gmail.com")
                .setPassword("COOPER$18");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isEmailAlertPresent("Wrong email format"));
        Assert.assertTrue(app.getHelperUser().isPasswordAlertPresent("Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]"));

    }

    @Test (enabled = false)
    public void registrationWrongEmailWrongPasswordNoNumber(){
        int z = (int) (System.currentTimeMillis()/1000%3600);

        User user = new User()
                .setFirstName("Henry")
                .setLastName("Cooper")
                .setEmail("cooper" + z + "gmail.com")
                .setPassword("Cooperwest$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isEmailAlertPresent("Wrong email format"));
        Assert.assertTrue(app.getHelperUser().isPasswordAlertPresent("Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]"));

    }

    @Test (enabled = false)
    public void registrationWrongEmailWrongPasswordNoSpecial(){
        int z = (int) (System.currentTimeMillis()/1000%3600);

        User user = new User()
                .setFirstName("Henry")
                .setLastName("Cooper")
                .setEmail("cooper" + z + "gmail.com")
                .setPassword("Cooperwest18");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isEmailAlertPresent("Wrong email format"));
        Assert.assertTrue(app.getHelperUser().isPasswordAlertPresent("Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]"));

    }
    
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void registrationEmptyName(){
        int z = (int) (System.currentTimeMillis()/1000%3600);
        User user = new User()
                .setFirstName("")
                .setLastName("Jackson")
                .setEmail("snow" + z + "@gmail.com")
                .setPassword("SsnowJ$59");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Name is required");
    }


    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void registrationEmptyLastName(){
        int z = (int) (System.currentTimeMillis()/1000%3600);
        User user = new User()
                .setFirstName("Lisa")
                .setLastName("")
                .setEmail("snow" + z + "@gmail.com")
                .setPassword("SsnowJ$59");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Last name is required");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void registrationEmptyEmail(){
        User user = new User()
                .setFirstName("Lisa")
                .setLastName("Jackson")
                .setEmail("")
                .setPassword("SsnowJ$59");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Email is required");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void registrationEmptyPassword(){
        User user = new User()
                .setFirstName("Lisa")
                .setLastName("Jackson")
                .setEmail("snow" + "@gmail.com")
                .setPassword("");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Password is required");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void registrationExistsUser(){
        User user = new User()
                .setFirstName("Lisa")
                .setLastName("Jackson")
                .setEmail("tipsytutor92@gmail.com")
                .setPassword("West1234$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"User already exists\"");
        app.getHelperUser().clickOkButton();

    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void registrationPolicyButtonNotChecked(){
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
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

    }




}
