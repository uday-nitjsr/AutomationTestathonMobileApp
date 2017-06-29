package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

/**
 * Created by asus on 6/29/2017.
 */
public class OwnersPage extends BasePage {

    public OwnersPage(RemoteWebDriver driver) {
        super(driver);
    }

    public WebElement getAllOwnerList(){
        return driver.findElement(By.xpath("//a[@routerlink='/owners']"));
    }

    public WebElement getAddNewButton(){
        return driver.findElement(By.xpath("//a[@routerlink='/owners/add']"));
    }

    public WebElement getHeaderTopTextElement(){
        return driver.findElement(By.xpath("//div[@class='container xd-container']/h2"));
    }

    public List<WebElement> getOwnerTableHeaderList(){
        return driver.findElements(By.xpath("//thead/tr/th"));
    }

    public WebElement getAddOwnerButton(){
        return driver.findElement(By.xpath("//div/button[@class='btn btn-default']"));
    }

    public WebElement firstNameTextField(){
        return driver.findElement(By.id("firstName"));
    }

    public WebElement lastNameTextField(){
        return driver.findElement(By.id("lastName"));
    }

    public WebElement addressTextField(){
        return driver.findElement(By.id("address"));
    }

    public WebElement cityTextField(){
        return driver.findElement(By.id("city"));
    }

    public WebElement telephoneTextField(){
        return driver.findElement(By.xpath(".//*[@id='telephone']"));
    }

    public void clickOnAddButton(){
        getAddNewButton().click();
    }
}
