package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperCar extends HelperBase{

    public HelperCar(WebDriver wd) {
        super(wd);
    }

    public void openCarForm() {
        pause(500);
        click(By.xpath("//a[text()=' Let the car work ']"));
    }

    public void fillCarForm(Car car) {
       typeLocation(car.getLocation());
       type(By.id("make"), car.getManufacture());
       type(By.id("model"), car.getModel());
       type(By.id("year"), car.getYear());
       select(By.id("fuel"), car.getFuel());
       type(By.id("seats"), String.valueOf(car.getSeats()));
       type(By.id("class"), car.getCarClass());
       type(By.id("serialNumber"), car.getCarRegNumber());
       //type(By.id("price"), String.valueOf(car.getPrice()));
        type(By.id("price"), car.getPrice()+"");
        type(By.id("about"), car.getFuel());
    }

    private void select(By locator, String option) {
        Select select = new Select(wd.findElement(locator));
        select.selectByValue(option);
    }

    private void typeLocation(String location) {
        type(By.id("pickUpPlace"), location);
        click(By.cssSelector("div.pac-item"));
    }

    public void submitCarForm() {

    }


    public void returnToHomePage() {
        click(By.xpath("//button[text()='Search cars']"));
    }

    public void attachPhoto(String link) {
        wd.findElement(By.id("photos")).sendKeys(link);
    }
}
