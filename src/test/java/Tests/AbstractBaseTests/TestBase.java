/*
 * Copyright 2014-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package Tests.AbstractBaseTests;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public abstract class TestBase {

    public static RemoteWebDriver driver;


    public abstract String getName();

    @BeforeTest
    public abstract void setUpPage();


    @BeforeSuite
    public void setUpAppium() throws MalformedURLException {

        final String URL_STRING = "http://127.0.0.1:4723/wd/hub";

        URL url = new URL(URL_STRING);

        //Use a empty DesiredCapabilities object
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
        capabilities.setCapability("deviceName","G4AXB7251910HBL");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability(CapabilityType.VERSION, "6.0.1");

        driver = new RemoteWebDriver(url, capabilities);

        //Use a higher value if your mobile elements take time to show up
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
        driver.get("http://ec2-13-229-31-126.ap-southeast-1.compute.amazonaws.com:4200/");
    }


    @AfterSuite
    public void tearDownAppium() {
        driver.close();
    }


    @BeforeClass
    public void navigateTo() throws InterruptedException {

    }


    @AfterClass
    public void restartApp() {
        driver.quit();
    }
}