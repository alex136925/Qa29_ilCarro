package tests;

import models.User;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.BeforeMethod;
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
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("You are logged in success"));
        app.getHelperUser().clickOkButton();
        app.getHelperUser().signOut();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
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

    @Test(retryAnalyzer = RetryAnalyzer.class)
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

    @Test(retryAnalyzer = RetryAnalyzer.class)
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

    @Test(retryAnalyzer = RetryAnalyzer.class)
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

    @Test(retryAnalyzer = RetryAnalyzer.class)
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

    @Test(retryAnalyzer = RetryAnalyzer.class)
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

    @Test(retryAnalyzer = RetryAnalyzer.class)
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

    @Test(retryAnalyzer = RetryAnalyzer.class)
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

    @Test(retryAnalyzer = RetryAnalyzer.class)
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

    @Test (retryAnalyzer = RetryAnalyzer.class)
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

    @Test (retryAnalyzer = RetryAnalyzer.class)
    public void registrationWrongEmailWrongPasswordNoSpecial(){
        int z = (int) (System.currentTimeMillis()/1000%3600);

        User user = new User()
                .setFirstName("Henry")
                .setLastName("Cooper")
                .setEmail("cooper" + z + "gmail.com")
                .setPassword("Cooperwest18");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isEmailAlertPresent("Wrong email format"));
        Assert.assertTrue(app.getHelperUser().isPasswordAlertPresent("Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]"));

    }
    





}
