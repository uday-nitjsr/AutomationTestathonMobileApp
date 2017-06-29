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

package Pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public abstract class BasePage {
    private static final int KEYBOARD_ANIMATION_DELAY = 1000;
    private static final int XML_REFRESH_DELAY = 1000;
    String destDir;

    /**
     * The driver
     */
    protected final RemoteWebDriver driver;

    public WebElement homeButton;

    public WebElement ownerButton;

    public WebElement veternarianButton;

    public WebElement petType;

    public WebElement specialtiesButton;

    public WebElement getHomeButton(){
        return    driver.findElement(By.xpath("//a[@title='home page']//span[contains(@class,'glyphicon')]"));
    }

    public WebElement getOwnerButton(){
        return driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[1]"));
    }

    public WebElement getVeternarianButton(){
        return driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[2]"));
    }

    public WebElement getPetType(){
        return driver.findElement(By.xpath("//a[@title='pettypes']"));
    }

    public WebElement getSpecialtiesButton(){
        return driver.findElement(By.xpath("//a[@title='specialties']"));
    }

    protected BasePage(RemoteWebDriver driver){
        this.driver = driver;
    }


    public void clickOnHome(){
        getHomeButton().click();
    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }
    protected boolean sendKeysToElement(String input, WebElement element, boolean appendNewLine) throws InterruptedException {
        final int MAX_ATTEMPTS = 3;
        int attempts = 0;

        do {
            element.clear();
            Thread.sleep(KEYBOARD_ANIMATION_DELAY);

            if (appendNewLine) {
                element.sendKeys(input + "\n");
            } else {
                element.sendKeys(input);
            }

            Thread.sleep(XML_REFRESH_DELAY);
        } while (!element.getText().contains(input) && ++attempts < MAX_ATTEMPTS);

        return element.getText().contains(input);
    }

    public boolean takeScreenShot(final String name) {
        String screenshotDirectory = System.getProperty("appium.screenshots.dir", System.getProperty("java.io.tmpdir", ""));
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        return screenshot.renameTo(new File(screenshotDirectory, String.format("%s.png", name)));
    }
}