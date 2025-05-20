package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[normalize-space(text())='Log in']")
        ));
        loginBtn.click();
    }


    public void openLoginFormFooter() {
        click(By.xpath("//a[text()='Log in']"));
    }


    public void fillLoginForm(String email, String password) {
        type(By.id("email"), email);
        type(By.id("password"),password);
    }

    public void fillLoginForm(User user) {
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }





    public String getFailMessage() {
        return wd.findElement(By.xpath("//*[contains(text(), 'look like email')]")).getText();
    }

    public String getErrorText() {
        return wd.findElement(By.cssSelector("div.error")).getText();
    }

    public boolean isYallaButtonNotActive() {
        boolean res = isElementPresent(By.cssSelector("button[disabled]"));
//=========================
        WebElement element = wd.findElement(By.cssSelector("button[type = 'submit']"));
        boolean result = element.isEnabled();

        return res && !result;

    }



    public void clickOkButton() {
        try {
            WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
            WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[normalize-space(text())='Ok']")
            ));
            okButton.click();
        } catch (Exception e) {
            System.out.println("OK button not found or not clickable: " + e.getMessage());
        }
    }


    public void signOut(){
        click(By.xpath("//*[text() = ' Logout ']"));
    }

    public boolean isLogged() {
        try {
            WebElement element = wd.findElement(By.xpath("//*[normalize-space(text()) = 'Logout']"));
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void openRegistrationForm() {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
        WebElement signUpBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space(text())='Sign up']")));
        signUpBtn.click();
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getFirstName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void checkPolicy() {
        //click(By.id("terms-of-use"));

        //click(By.cssSelector("label[for='terms-of-use']"));

        //option 3
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').click();");
    }

    public void checkPolicyXY(){
        if (wd.findElement(By.id("terms-of-use")).isSelected()) {


            WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']"));

            Rectangle rec = label.getRect();
            int w = rec.getWidth();

            int xOffSet = -w / 2;


            Actions actions = new Actions(wd);
            actions.moveToElement(label, xOffSet, 0).click().release().perform();
        }
    }

    public void login(User user) {
        openLoginForm();
        fillLoginForm(user);
        submit();
        clickOkButton();
    }



    //"button[disabled]" for Yallah button
    // WebElement element = wd.findElement(By.cssSelector("button[type = 'submit'));
    //boolean result = element.isEnabled();
}

