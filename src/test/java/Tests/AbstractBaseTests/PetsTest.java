package Tests.AbstractBaseTests;

import Pages.HomePage;
import Pages.PetsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by asus on 6/29/2017.
 */
public class PetsTest extends TestBase {
    PetsPage petsPage;
    @Override
    public String getName() {
        return null;
    }

    @BeforeTest
    @Override
    public void setUpPage(){
        try {
            petsPage = new PetsPage(driver);
            petsPage.getPetType().click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void verifyPageTopHeader(){
        Assert.assertEquals(petsPage.getHeaderTopTextElement().getText(),"Pets Type");
    }
}
