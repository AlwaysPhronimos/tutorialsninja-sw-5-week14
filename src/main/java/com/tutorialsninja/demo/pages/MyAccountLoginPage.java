package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MyAccountLoginPage extends Utility {
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailAddress;
    @CacheLookup
    @FindBy(name = "password")
    WebElement enterPassword;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'My Account')]")
    WebElement myAccountText;

    public void enterEmailAddress() {
        sendTextToElement(emailAddress, "qwe0@gmail.com");
    }

    public void enterValidPassword() {
        sendTextToElement(enterPassword, "qwe123");
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }

    public String getMyAccountText() {
        return getTextFromElement(myAccountText);
    }
}

