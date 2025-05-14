package tests;

import models.Car;
import models.User;
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
    public  void addNewCarSuccess(){
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
        app.getHelperCar().fillCarForm();
        app.getHelperCar().submitCarForm();
    }
}
