package tests;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestBase{

    @BeforeClass
    public void preCondition(){
        if (!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().setEmail("tipsytutor92@gmail.com").setPassword("West1234$"));
        }
    }

    @Test
    public  void addNewCarSuccessAll(){
        int i = (int) ((System.currentTimeMillis()/1000)%600);

        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("BMW")
                .model("M5")
                .year("2024")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .carRegNumber("678-900" + i)
                .price(50.)
                .about("Great car")
                .build();

        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().attachPhoto("C:\\GitHub\\Qa29_ilCarro\\bugatti.jpg");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().getMessage().contains("added successful"));
        Assert.assertEquals(app.getHelperCar().getMessage(), car.getManufacture() + " " + car.getModel() + " " + "added successful");
    }

    @Test
    public  void addNewCarSuccess(){
        int i = (int) ((System.currentTimeMillis()/1000)%600);

        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Mazda")
                .model("M3")
                .year("2022")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .carRegNumber("674-900" + i)
                .price(48.)
                .build();

        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().getMessage().contains("added successful"));
        Assert.assertEquals(app.getHelperCar().getMessage(), car.getManufacture() + " " + car.getModel() + " " + "added successful");
    }


    @AfterMethod
    public  void  postCondition(){
        app.getHelperCar().returnToHomePage();
    }
}
