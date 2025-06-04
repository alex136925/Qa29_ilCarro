package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd){
        this.wd = wd;
    }

    public void type(By locator, String text){
        WebElement element = wd.findElement(locator);

        element.click();
        element.clear();
        clearNew(element);
        if (text != null){
            element.sendKeys(text);
        }
    }

    public boolean isYallaButtonNotActive() {
        boolean res = isElementPresent(By.cssSelector("button[disabled]"));
//=========================
        WebElement element = wd.findElement(By.cssSelector("button[type = 'submit']"));
        boolean result = element.isEnabled();

        return res && !result;

    }

    public String getErrorText() {
        return wd.findElement(By.cssSelector("div.error")).getText();
    }

    public void clearTextBox(By locator){
        WebElement el = wd.findElement(locator);
        String os = System.getProperty("os.name");

        if (os.startsWith("Win")){
            el.sendKeys(Keys.CONTROL, "a");
        }else{
            el.sendKeys(Keys.COMMAND, "a");
        }

        el.sendKeys(Keys.DELETE);
    }

    public  void clearNew(WebElement element){
        element.sendKeys(" ");
        element.sendKeys(Keys.BACK_SPACE);
    }

    public void click(By locator){
        WebElement element = wd.findElement(locator);
        element.click();
    }

    public boolean isAlertPresent(String message){
        WebElement alert = new WebDriverWait(wd, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable (By.cssSelector(".dialog-container>h2")));
        if (alert != null && alert.getText().contains(message)){
            alert.click();
            return  true;
        }
        return  false;
    }

    public boolean isEmailAlertPresent(String message){
        WebElement alert = new WebDriverWait(wd, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated (By.xpath("//div[contains(text(), 'Wrong')]")));
        return alert != null && alert.getText().contains(message);
    }

    public boolean isPasswordAlertPresent(String message){
        WebElement alert = new WebDriverWait(wd, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated (By.xpath("//div[contains(text(), 'must')]")));
        return alert != null && alert.getText().contains(message);


    }

    public boolean isLoginFormPresent() {
        try {
            WebElement loginForm = wd.findElement(By.xpath("//a[text()=' Log in ']"));
            return loginForm.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getMessage() {
//        WebElement element = wd.findElement(By.cssSelector(".dialog-container>h2"));
//        String text = element.getText();
//        return text;
        pause(2000);
        return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();

    }

    public void getScreen(String link) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) wd;
        File tmp =  takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(tmp,new File(link));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isLogoutVisible() {
        try {
            WebElement logOut = wd.findElement(By.xpath("//*[text()=' Log out ']"));
            return logOut.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void submit() {
        click(By.xpath("//*[@type='submit']"));
    }

    public boolean isElementPresent(By locator){

        return wd.findElements(locator).size() > 0;
    }
}


