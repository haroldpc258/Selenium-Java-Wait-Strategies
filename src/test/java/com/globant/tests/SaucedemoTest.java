package com.globant.tests;

import com.globant.pages.FirstPage;
import com.globant.pages.ResultPage;
import com.globant.utils.baseTest.BaseTest;
import com.globant.utils.dataProvider.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SaucedemoTest extends BaseTest {

    @Test
    @Parameters({ "usernameInput", "passwordInput" })
    public void loginTestNoWait(String usernameInput, String passwordInput) {
        FirstPage home = loadFirstPage();
        ResultPage resultPage = home.login(usernameInput, passwordInput);
        Assert.assertTrue(resultPage.inventoryIsAvailable());
    }

    @Test
    @Parameters({ "usernameInput", "passwordInput" })
    public void loginTestImplicitWait(String usernameInput, String passwordInput) {
        FirstPage home = loadFirstPage();
        setUpImplicitWait(10);
        ResultPage resultPage = home.login(usernameInput, passwordInput);
        Assert.assertTrue(resultPage.inventoryIsAvailable());
    }

    @Test
    @Parameters({ "usernameInput", "passwordInput" })
    public void loginTestExplicitWait(String usernameInput, String passwordInput) {
        Wait<WebDriver> wait = setUpExplicitWait(2);
        FirstPage home = loadFirstPage(wait);
        ResultPage resultPage = home.loginWithWait(wait, usernameInput, passwordInput);
        Assert.assertTrue(resultPage.inventoryIsAvailable());
    }

    @Test(description = "Test Login with DP", dataProvider = "credentialsData", dataProviderClass = Data.class)
    public void loginTestFluentWait(String usernameInput, String passwordInput) {
        Wait<WebDriver> wait = setUpFluentWait(2, 300);
        FirstPage home = loadFirstPage(wait);
        ResultPage resultPage = home.loginWithWait(wait, usernameInput, passwordInput);
        Assert.assertTrue(resultPage.inventoryIsAvailable());
    }
}
