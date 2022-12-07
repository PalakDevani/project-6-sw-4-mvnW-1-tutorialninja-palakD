package com.tutorialninja.demo.testsuite;

import com.tutorialninja.demo.pages.HomePage;
import com.tutorialninja.demo.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    HomePage homepage = new HomePage();


    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homepage.clickOnDesktopLink();
        homepage.selectMenu("Show All Desktops");
        Assert.assertEquals(homepage.getVerifyText(), "Desktops", "Error Message not displayed");

    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        homepage.clickOnLaptopNotebooksLink();
        homepage.selectMenu("Show All Laptops & Notebooks");
        Assert.assertEquals(homepage.getVerifyText1(), "Laptops & Notebooks", "Error Message not displayed");

    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        homepage.clickOnComponantsLink();
        homepage.selectMenu("Show All Components");
        Assert.assertEquals(homepage.getVerifyText2(), "Components", "Error Message not displayed");
    }

}