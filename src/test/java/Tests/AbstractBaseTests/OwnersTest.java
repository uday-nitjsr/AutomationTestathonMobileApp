package Tests.AbstractBaseTests;

import Pages.BasePage;
import Pages.HomePage;
import Pages.OwnersPage;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by asus on 6/29/2017.
 */
public class OwnersTest extends TestBase {
    OwnersPage ownersPage;

    public String getName() {
        return null;
    }

    @BeforeTest
    public void setUpPage(){
        try {
            ownersPage = new OwnersPage(driver);
            ownersPage.getOwnerButton().click();
            ownersPage.getAllOwnerList().click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    public void verifyTable(){
        Assert.assertEquals(ownersPage.getOwnerTableHeaderList().get(0).getText(),"Name");
        Assert.assertEquals(ownersPage.getOwnerTableHeaderList().get(1).getText(),"Address");
        Assert.assertEquals(ownersPage.getOwnerTableHeaderList().get(2).getText(),"City");
        Assert.assertEquals(ownersPage.getOwnerTableHeaderList().get(3).getText(),"Telephone");
        Assert.assertEquals(ownersPage.getOwnerTableHeaderList().get(4).getText(),"Pets");
    }

    @Test(priority = 2)
    public void verifyAddOwnerForm(){
        ownersPage.getAddNewButton().click();
        Assert.assertEquals(ownersPage.getHeaderTopTextElement().getText(),"New Owner");
        Assert.assertEquals(ownersPage.firstNameTextField().isDisplayed(),true);
        Assert.assertEquals(ownersPage.lastNameTextField().isDisplayed(),true);
        Assert.assertEquals(ownersPage.addressTextField().isDisplayed(),true);
        Assert.assertEquals(ownersPage.cityTextField().isDisplayed(),true);
        Assert.assertEquals(ownersPage.telephoneTextField().isDisplayed(),true);
    }


}
