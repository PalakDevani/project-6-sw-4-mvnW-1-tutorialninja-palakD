package com.tutorialninja.demo.pages;

import com.google.common.base.Verify;
import com.tutorialninja.demo.utility.Utility;
import dev.failsafe.internal.util.Assert;
import javafx.scene.control.Tab;
import org.bouncycastle.util.test.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {

    By selectLaptopsAndNotebookstab = By.linkText("Laptops & Notebooks");

    public void clickOnLaptopsAndNotebooksTab() {
        clickOnElement(selectLaptopsAndNotebookstab);
    }

    By showAllLaptopsAndNotebookstab = By.linkText("Show All Laptops & Notebooks");

    public void clickOnShowAllLaptopsAndNotebooksTab() {
        clickOnElement(showAllLaptopsAndNotebookstab);
    }

    By clickOnSortByOption = By.xpath("//select[@id='input-sort']");
    public void setClickOnSortByOption(){
        clickOnElement(clickOnSortByOption);
    }

    By sortByPriceHighToLow = By.xpath("//option[contains(text(),'Price (High > Low)')]");
    public void setSortByPriceHighToLow(){
        // Get all the products price and stored into array list
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
        }
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);
        // Select sort by Price (High > Low)
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");
        // After filter Price (High > Low) Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
        }
        System.out.println(afterSortByPrice);


    }
    By selectProductMacBook = By.linkText("MacBook");
    By verifyTheTextMacBook = By.xpath("//h1[contains(text(),'MacBook')]");
    By clickOnAddToCartButton = By.xpath("//button[@id='button-cart']");
    By verifyTheMessageSuccess = By.xpath("//body/div[@id='product-product']/div[1]");
    By clickOnLinkShoppingCartDisplayInToSuccessMessage = By.xpath("//a[contains(text(),'shopping cart')]");
    By verifyTheTextShoppingCart = By.xpath("//a[contains(text(),'shopping cart')]");
    By verifyTheProductNameMacBook = By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]");
    By changeQuantity = By.xpath("//input[@name='quantity[133654]']"); // By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]");
    By clickOnUpdateTab = By.xpath("//button[@data-original-title='Update']");
    By verifyTheMessageModifiedShoppingCart = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By verifyTheTotal = By.xpath("//header/div[1]/div[1]/div[3]/div[1]/button[1]");
    By clickOnCheckoutButton = By.xpath("//a[contains(text(),'Checkout')]");
    By verifyTheTextCheckout = By.xpath("//h1[contains(text(),'Checkout')]");
    By verifyTheTextNewCustomer = By.xpath("//h2[contains(text(),'New Customer')]");
    By clickOnGuestCheckoutRadioButton = By.xpath("//input[@type='radio' and @value='guest']");
    By clickOnContinueTab = By.xpath("//input[@id='button-account']");
    By firstNameField = By.id("input-payment-firstname");
    By lastNameField = By.id("input-payment-lastname");
    By emailField = By.id("input-payment-email");
    By telephoneField = By.id("input-payment-telephone");
    By address1Field = By.id("input-payment-address-1");
    By cityField = By.id("input-payment-city");
    By postcodeField = By.id("input-payment-postcode");
    By countryField = By.xpath("//select[@id='input-payment-country']");
    By regionField = By.xpath("//select[@id='input-payment-zone']");
    By FillTheMandatoryFieldsAndClickOnContinueButton = By.xpath("//input[@id='button-guest']");
    By addCommentsAboutYourOrderInToTextArea = By.xpath("//textarea[@name='comment']");
    By checkTheTermsConditionsCheckBox = By.xpath("//input[@type='checkbox']");
    By clickOnFinalContinueButton = By.xpath("//input[@id='button-payment-method']");
    By verifyTheMessageWarningPaymentMethodRequired = By.xpath("//div[contains(@class,'alert alert-danger')]");


}
