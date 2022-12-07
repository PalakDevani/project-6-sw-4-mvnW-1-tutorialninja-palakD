package com.tutorialninja.demo.pages;

import com.tutorialninja.demo.utility.Utility;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DesktopsPage extends Utility {

    By selectDesktopsTab = (By.linkText("Desktops"));
    By clickOnShowAllDeskTop = (By.linkText("Show All Desktops"));
    By productsListDisplay = (By.xpath("//h4/a"));
    By selectSortByNameZToA = By.xpath("//select[@id='input-sort']");
    By selectSortByNameAToZ = By.xpath("//select[@id='input-sort']");
    By selectProductHPLP3065 = By.linkText("HP LP3065");
    By verifyTextHPLP3065 = By.xpath("//h1[contains(text(),'HP LP3065')]");
    By selectDeliveryDate = By.xpath("//button[@class = 'btn btn-default']/i[@class='fa fa-calendar']");
    By selectMonthYear = By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[2]");
    By allDate = By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']");

    By enterQuantity = By.id("input-quantity");
    By selectAddToCartButton = By.xpath("//button[@id='button-cart']");
    By verifyTheSuccessMessage = By.xpath("//div[@class ='alert alert-success alert-dismissible']");
    By selectShoppingCartLink = By.xpath("//button[@id='button-cart']"); //By.xpath("//a[contains(text(),'shopping cart')]");
    By verifyTheTextShoppingCart = By.xpath("//a[contains(text(),'shopping cart')]");  //By.xpath("//div[@id='content']//h1");
    By verifyTheProductNameHPLP3065 = By.xpath("//h1[contains(text(),'HP LP3065')]");
    By verifyTheDeliveryDate = By.xpath("//small[contains(text(),'Delivery Date: 2023-11-30')]");

    By verifyModel = By.xpath("//td[contains(text(),'Product 21')]");
    By currencyLink = By.xpath("//span[contains(text(),'Currency')]");
    By selectCurrencyPoundSterling = By.xpath("//button[contains(text(),'£ Pound Sterling')]");
    By verifyTheTotal = By.xpath("//tbody/tr[1]/td[6]");

    public void clickOnDesktopsTab() {
        clickOnElement(selectDesktopsTab);
    }

    public void clickOnShowAllDesktop() {
        clickOnElement(clickOnShowAllDeskTop);
    }

    public String getOriginalProductDispalyList() {
        List<WebElement> products = driver.findElements(productsListDisplay);
        ArrayList<String> originalProductName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductName.add(e.getText());
        }
        System.out.println(originalProductName);
        return getTextFromElement(productsListDisplay);
    }

    public String getProductSortByZTOA() {
        selectByVisibleTextFromDropDown(selectSortByNameZToA, "Name (Z - A)");
        List<WebElement> products = driver.findElements(productsListDisplay);
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }

        System.out.println(afterSortByZToAProductsName);

        return getTextFromElement(selectSortByNameZToA);
    }

    public String getProductSortByAToZ() {
        selectByVisibleTextFromDropDown(selectSortByNameAToZ, "Name (A - Z)");
        List<WebElement> products = driver.findElements(productsListDisplay);
        ArrayList<String> afterSortByAToZProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByAToZProductsName.add(e.getText());
        }

        System.out.println(afterSortByAToZProductsName);

        return getTextFromElement(selectSortByNameAToZ);
    }

    public void clickOnHPLP3065() {
        clickOnElement(selectProductHPLP3065);
    }

    public String getTextHPLP3065() {
        return getTextFromElement(verifyTextHPLP3065);
    }

    public void selectDeliveryDate() {
        String year = "2023";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        while (true) {
            String monthAndYear = driver.findElement(selectMonthYear).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class ='datepicker']/div[1]//th[@class='next']"));
            }
        }
        List<WebElement> allDates = driver.findElements(allDate);
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;
            }
        }
    }

    public void enterTheQuantity1() {
        clearText(enterQuantity);
        sendTextToElement(enterQuantity, "1");
    }

    public void clickOnAddToCartButton() {
        clickOnElement(selectAddToCartButton);
    }

    public String verifySuccessMessage() {
        return getTextFromElement(verifyTheSuccessMessage);
    }

    public void clickOnShoppingCartInToSuccessMessage() {
        clickOnElement(selectShoppingCartLink);
    }

    public String getShoppingCartText() {
        return getTextFromElement(verifyTheTextShoppingCart);
    }

    public String getProductNameIsHPLP3065() {
        return getTextFromElement(verifyTheProductNameHPLP3065);
    }

    public String getTheDeliveryDateIs20231130() {
        return getTextFromElement(verifyTheDeliveryDate);
    }

    public String getTheModelIsProduct21() {
        return getTextFromElement(verifyModel);
    }

    public void clickOnCurrencyDropDown() {
        clickOnElement(currencyLink);
        //selectCurrencyPoundSterling
        List<WebElement> currencyList = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu']/li"));
        for (WebElement e : currencyList) {
            if (e.getText().equalsIgnoreCase("£ Pound Sterling")) {
                e.click();
                break;
            }
        }
    }

    public String getToatl() {
        return getTextFromElement(verifyTheTotal);
    }
}




