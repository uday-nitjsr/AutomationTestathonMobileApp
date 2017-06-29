package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by ASUS on 08-11-2016.
 */
public class HomePage extends BasePage {

    public HomePage(RemoteWebDriver driver) {
        super(driver);
    }

    WebElement welcomeTextElement;

    public WebElement getWelcomeTextElement(){
        return driver.findElement(By.cssSelector("app-welcome h1"));
    }

}
