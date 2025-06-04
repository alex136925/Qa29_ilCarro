package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    public void searchCurrentMonth(String city, String dateFrom, String dateTo) {
        typeCity(city);
        click(By.id("dates"));

        String[] from = dateFrom.split("/");
        String[] to = dateTo.split("/");

        String locatorFrom = "//div[text() =' "+from[1]+" ']";
        String locatorTo = "//div[text() =' "+to[1]+" ']";

        click(By.xpath(locatorFrom));
        click(By.xpath(locatorTo));
    }

    private void typeCity(String city) {
        type(By.id("city"), city);
        click(By.cssSelector("div.pac-item"));
    }

    public boolean isListOfCarsAppeared() {
        return isElementPresent(By.cssSelector("a.car-container"));
    }

    public void searchCurrentYear(String city, String dateFrom, String dateTo) {
        typeCity(city);
        click(By.id("dates"));
        LocalDate now = LocalDate.now();
        System.out.println(now);

        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();

        LocalDate from = LocalDate.parse(dateFrom, DateTimeFormatter.ofPattern("M/d/yyyy"));
        LocalDate to = LocalDate.parse(dateTo, DateTimeFormatter.ofPattern("M/d/yyyy"));

        int diffMonth = from.getMonthValue() - month;
        if (diffMonth > 0){
            clickNextMonthBtn(diffMonth);
        }

        click(By.xpath("//div[text()=' "+from.getDayOfMonth()+" ']"));

        diffMonth = to.getMonthValue() - from.getMonthValue();
        if (diffMonth > 0){
            clickNextMonthBtn(diffMonth);
        }

        click(By.xpath("//div[text()=' "+to.getDayOfMonth()+" ']"));

    }

    private void clickNextMonthBtn(int diffMonth) {
        for (int i = 0; i < diffMonth; i++) {
            click(By.xpath("//button[@aria-label='Next month']"));

        }
    }

    public void searchAnyPeriod(String city, String dateFrom, String dateTo){
        typeCity(city);
        click(By.id("dates"));

        LocalDate now = LocalDate.now();
        LocalDate from = LocalDate.parse(dateFrom, DateTimeFormatter.ofPattern("M/dd/yyyy"));
        LocalDate to = LocalDate.parse(dateTo, DateTimeFormatter.ofPattern("M/dd/yyyy"));

        int diffYear;
        int diffMonth;

        //***from
        diffYear = from.getYear() - now.getYear();
        if (diffYear == 0){
            diffMonth = from.getMonthValue() - now.getMonthValue();
        } else {
            diffMonth = 12 - now.getMonthValue();
        }

        clickNextMonthBtn(diffMonth);
        click(By.xpath("//div[text()=' "+from.getDayOfMonth()+" ']"));

        //***to
        diffYear = to.getYear() - from.getYear();
        if (diffMonth==0){
            diffMonth = to.getMonthValue() - from.getMonthValue();
        } else {
            diffMonth = 12 - from.getMonthValue() + to.getMonthValue();
        }

        clickNextMonthBtn(diffMonth);
        click(By.xpath("//div[text()=' "+to.getDayOfMonth()+" ']"));




//        LocalDate from = LocalDate.parse(dateFrom, DateTimeFormatter.ofPattern("M/d/yyyy"));
//        LocalDate to = LocalDate.parse(dateTo, DateTimeFormatter.ofPattern("M/d/yyyy"));
//
//        String monthFrom = from.getMonth().toString().substring(0, 3).toUpperCase();
//        String monthTo = to.getMonth().toString().substring(0, 3).toUpperCase();
//
//        click(By.xpath("//button[@aria-label='Choose month and year']"));
//        click(By.xpath("//div[text()=' " + from.getYear() + " ']"));
//        click(By.xpath("//div[text()=' " + monthFrom + " ']"));
//        click(By.xpath("//div[text()=' " + from.getDayOfMonth() + " ']"));
//
//        click(By.xpath("//button[@aria-label='Choose month and year']"));
//        click(By.xpath("//div[text()=' " + to.getYear() + " ']"));
//        click(By.xpath("//div[text()=' " + monthTo + " ']"));
//        click(By.xpath("//div[text()=' " + to.getDayOfMonth() + " ']"));

    }

    public void searchNotValidPeriod(String city, String dateFrom, String dateTo) {
        typeCity(city);
        clearTextBox(By.id("dates"));
        type(By.id("dates"), dateFrom+" - "+dateTo);
        click(By.cssSelector("div.cdk-overlay-backdrop"));

    }

    public  void navigateByLogo(){
        click(By.cssSelector("a.logo"));
    }

}
