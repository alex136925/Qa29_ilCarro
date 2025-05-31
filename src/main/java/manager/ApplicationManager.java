package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
WebDriver wd;

HelperUser helperUser;
HelperCar helperCar;

public void init(){
    wd = new ChromeDriver();
    logger.info("All tests run in Chrome Browser");
    wd.manage().window().maximize();
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    WebDriverListener webDriverListener = new WDListener();
    wd = new EventFiringDecorator(webDriverListener).decorate(wd);

    wd.navigate().to("https://ilcarro.web.app/");
    helperUser = new HelperUser(wd);
    helperCar = new HelperCar(wd);
}

public void stop(){
    wd.quit();
}

    public HelperUser getHelperUser() {

    return helperUser;
    }

    public HelperCar getHelperCar() {
        return helperCar;
    }
}
