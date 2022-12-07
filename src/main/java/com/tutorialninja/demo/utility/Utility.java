package com.tutorialninja.demo.utility;

import com.google.common.base.Function;
import com.tutorialninja.demo.browserfactory.ManageBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class Utility extends ManageBrowser {

    public static String getAlphaNumericString(int n) {
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int) (AlphaNumericString.length() * Math.random());
            // add Character one by one in end of sb
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }


    // this method will click on element
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();// this method will click on element
    }

    // this method will get text from element
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();

    }// this method will send text to element

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);


    }
    //************************  Alert methods  **************************

    // this method will switch to alert
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    // this method will accept alert
    public void switchToAcceptAlert() {
        driver.switchTo().alert().accept();

    } // this method will dismiss alert

    public void switchToDismissAlert() {
        driver.switchTo().alert().dismiss();

    }

    // this method will  get text from alert
    public String getTextFromAlert(By by) {
        return driver.switchTo().alert().getText();

    }

    // this method will sendTextToAlert(String Text)

    public void sendTextToAlert(By by, String text) {
        driver.switchTo().alert().sendKeys(text);
        //driver.findElement(by).sendTextToAlert(by,text);
    }

    //************************* clear method*********************

    public void clearText(By by) {
        Actions actions = new Actions(driver);
        WebElement quantity = driver.findElement(by);
        quantity.clear();
    }
//****************verify class method**********

//    public void verifyExpectedAndActual(By by, String expectedText) {
//        String actualText = getTextFromElement(by);
//        Assert.assertEquals(expectedText, actualText);

    //}

//    public void verifyMessage(String expectedMessage, String actualMessage) {
//        Assert.assertEquals(expectedMessage, actualMessage);
//    }
//*****************  Select class Methods *************************

    // below method will select option by visible text
    public void selectByVisibleTextFromDropDown(By by, String text) {
        //only n only SELECT TAG(html starting from select) in the inspect console then only use the below methods
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
    //this method will select option by Value

    public void selectByValueFromDropDown(By by, String value) {
        new Select(driver.findElement(by)).selectByValue(value);
    }

    //this method will select option by Index - like 1.2.3
    public void selectByIndexFromDropDown(By by, int index) {
        new Select(driver.findElement(by)).selectByIndex(index);
    }

    //this method will select option by contains text
    public void selectByContainsTextFromDropDown(By by, String text) {
        List<WebElement> allOptions = new Select(driver.findElement(by)).getOptions();
        for (WebElement options : allOptions) {
            if (options.getText().contains(text)) {
                options.click();
            }
        }
    }


/* black colour text are option visible text


    //**********************switch to windows***********/

    //This method will close all windows
    public void closeAllWindows(List<String> hList, String parentWindow) {
        for (String str : hList) {
            if (!str.equals(parentWindow)) {
                driver.switchTo().window(str).close();
            }
        }
    }

    //This method will switch to parent window
    public void switchToParentWindow(String parentWindowId) {
        driver.switchTo().window(parentWindowId);
    }

    //This method will find that we switch to right window
    public boolean switchToRightWindow(String windowTitle, List<String> hList) {
        for (String str : hList) {
            String title = driver.switchTo().window(str).getTitle();
            if (title.contains(windowTitle)) {
                System.out.println("Found the right window....");
                return true;
            }
        }
        return false;
    }//******************  waits class methods   **************

    //This method will use to wait until  VisibilityOfElementLocated
    public WebElement waitUntilVisibilityOfElementLocated(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForElementWithFluentWait(final By by, int time, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;

    }


    //*************************************Action class method**************************

    //mouseHoverToElement(By by),
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();


    }

    //mouseHoverToElementAndClick(By by)
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();


    }

    //Drag and Drop Element
    public void dragAndDrop(By by, By by1) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(by), driver.findElement(by1)).build().perform();

    }

}
