package Tests.AbstractBaseTests;

import Pages.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by ASUS on 08-11-2016.
 */
public class HomePageTest extends TestBase{
    public HomePage homePage;

    @Override
    public String getName() {
        return null;
    }

    @BeforeTest
    @Override
    public void setUpPage(){
        try {
            homePage = new HomePage(driver);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(enabled = true)
    public void checkHeader() throws InterruptedException {
        homePage.clickOnHome();
        Assert.assertEquals(homePage.getCurrentURL().contains("/welcome"),true);
        Assert.assertEquals(homePage.getWelcomeTextElement().getText(),"Welcome to Dr. Dolittle Petclinic");
    }

}
