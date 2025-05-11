package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        if (text != null){
            element.sendKeys(text);
        }
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

    public boolean isLoginFormPresent() {
        try {
            WebElement loginForm = wd.findElement(By.xpath("//a[text()=' Log in ']"));
            return loginForm.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
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

    public  void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isElementPresent(By locator){

        return wd.findElements(locator).size() > 0;
    }
}


