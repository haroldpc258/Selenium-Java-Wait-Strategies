package com.globant.utils.baseTest;

import com.globant.pages.FirstPage;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters({ "browser", "url" })
    public void setUp(String browser, String url) {
        setUpDriver(browser);
        maximizeWindow();
        navigateTo(url);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public FirstPage loadFirstPage() {
        return new FirstPage(driver);
    }

    public FirstPage loadFirstPage(Wait<WebDriver> wait) {
        return new FirstPage(driver, wait);
    }

    public void setUpImplicitWait(int timeout) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }

    public Wait<WebDriver> setUpExplicitWait(int timeout) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public Wait<WebDriver> setUpFluentWait(int timeout, int polling) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(polling))
                .ignoring(ElementNotInteractableException.class);
    }

    private void navigateTo(String url) {
        driver.get(url);
    }

    private void maximizeWindow() {
        driver.manage().window().maximize();
    }

    private void setUpDriver(String browser) {
        switch (browser) {
            case "chrome" -> {
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                driver = new FirefoxDriver();
            }
            case "edge" -> {
                driver = new EdgeDriver();
            }
        }
    }
}
