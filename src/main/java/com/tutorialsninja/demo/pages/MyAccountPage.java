package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyAccountPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement MyAccountTab;

    @CacheLookup
    @FindBy(xpath = "//div[@id ='top-links']//li[@class='hidden-xs hidden-sm hidden-md']/ul/li")
    WebElement MyAccountOptions;

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Register Account']")
    WebElement RegisterAccountText;
    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Returning Customer']")
    WebElement ReturningCustomerText;

    @CacheLookup
    @FindBy(xpath = "//ul[@class = 'dropdown-menu dropdown-menu-right']//li")
    List<WebElement> TopMenu;
    @CacheLookup
    @FindBy(xpath = "//span[text()='My Account']")
    WebElement MyAccount1;

    public void clickOnMyAccountTab() {
        mouseHoverToElementAndClick(MyAccountTab);
    }

    public void clickOnMyAccount1() {
        mouseHoverToElementAndClick(MyAccount1);
    }

    public String getRegisterAccountText() {
        return getTextFromElement(RegisterAccountText);

    }

    public String getReturningCustomerText() {
        return getTextFromElement(ReturningCustomerText);
    }

    public void selectMyAccountOptions(String option) {
        try {
            List<WebElement> list = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu dropdown-menu-right']//li"));
            for (WebElement listOfElement : list) {
                if (listOfElement.getText().equals(option)) {
                    listOfElement.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            List<WebElement> list = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu dropdown-menu-right']//li"));
        }
    }
}
