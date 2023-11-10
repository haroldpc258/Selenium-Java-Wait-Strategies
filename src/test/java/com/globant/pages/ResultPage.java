package com.globant.pages;

import com.globant.utils.basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultPage extends BasePage {

    @FindBy(id = "inventory_container")
    private WebElement inventoryDiv;

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean inventoryIsAvailable() {
        return inventoryDiv.isEnabled() && inventoryDiv.isDisplayed();
    }

}
