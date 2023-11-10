package com.globant.pages;

import com.globant.utils.basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;

public class FirstPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public FirstPage(WebDriver driver) {
        super(driver);
    }

    public FirstPage(WebDriver driver, Wait<WebDriver> wait) {
        super(driver, wait);
    }

    public ResultPage login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new ResultPage(driver);
    }

    public ResultPage loginWithWait(Wait<WebDriver> wait, String username, String password) {

        waitVisibilityOf(usernameInput);
        usernameInput.sendKeys(username);

        waitVisibilityOf(passwordInput);
        passwordInput.sendKeys(password);

        waitToBeClickable(loginButton);
        loginButton.click();
        return new ResultPage(driver);
    }
}
