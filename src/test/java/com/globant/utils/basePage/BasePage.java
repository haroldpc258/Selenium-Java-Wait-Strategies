package com.globant.utils.basePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected Wait<WebDriver> wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public BasePage(WebDriver driver, Wait<WebDriver> wait) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void waitToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitVisibilityOf(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
