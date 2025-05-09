package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void submitLogin() {
        click(By.xpath("//*[@type='submit']"));
    }

    public String getMessage() {
//        WebElement element = wd.findElement(By.cssSelector(".dialog-container>h2"));
//        String text = element.getText();
//        return text;
        return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();

    }

    public String getFailMessage() {
        return wd.findElement(By.xpath("//*[contains(text(), 'look like email')]")).getText();
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
}

