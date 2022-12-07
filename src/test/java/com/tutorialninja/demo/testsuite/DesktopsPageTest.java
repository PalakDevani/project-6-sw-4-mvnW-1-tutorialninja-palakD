package com.tutorialninja.demo.testsuite;

import com.tutorialninja.demo.pages.DesktopsPage;
import com.tutorialninja.demo.pages.HomePage;
import com.tutorialninja.demo.testbase.BaseTest;
import com.tutorialninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DesktopsPageTest extends BaseTest {

    DesktopsPage desktopspage = new DesktopsPage();


    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        desktopspage.clickOnDesktopsTab();
        desktopspage.clickOnShowAllDesktop();
        desktopspage.getOriginalProductDispalyList();
        desktopspage.getProductSortByZTOA();

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        desktopspage.clickOnCurrencyDropDown();
        desktopspage.clickOnDesktopsTab();
        desktopspage.clickOnShowAllDesktop();
        desktopspage.getOriginalProductDispalyList();
        desktopspage.getProductSortByAToZ();
        desktopspage.clickOnHPLP3065();
        Assert.assertEquals(desktopspage.getTextHPLP3065(), "HP LP3065", "HP LP3065 not displayed");
        desktopspage.selectDeliveryDate();
        Thread.sleep(5000);
        desktopspage.enterTheQuantity1();
        desktopspage.clickOnAddToCartButton();
        Assert.assertEquals(desktopspage.verifySuccessMessage(), "Success: You have added HP LP3065 to your shopping cart!\n" +
                "×", "Success Message not displayed");
        Thread.sleep(5000);
        desktopspage.clickOnShoppingCartInToSuccessMessage();
        Assert.assertEquals(desktopspage.getShoppingCartText(), "shopping cart", "Shopping Cart text not displayed");
        Assert.assertEquals(desktopspage.getProductNameIsHPLP3065(), "HP LP3065", "Product name is not HP LP3065");
        Thread.sleep(1000);
        Assert.assertEquals(desktopspage.getTheDeliveryDateIs20231130(), "Delivery Date: 2023-11-30", "Delivery date is not 2023-11-30");
        Assert.assertEquals(desktopspage.getTheModelIsProduct21(), "Product 21", "Error Message not displayed");
        Assert.assertEquals(desktopspage.getToatl(), "£74.73");
    }
}
