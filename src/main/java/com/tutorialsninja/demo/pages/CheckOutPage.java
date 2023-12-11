package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-firstname']")
    WebElement firstNameField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-lastname']")
    WebElement lastNameField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-email']")
    WebElement emailField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-telephone']")
    WebElement telephoneField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-address-1']")
    WebElement addressField;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-city']")
    WebElement cityField;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-postcode']")
    WebElement postcodeField;
    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-country']")
    WebElement countryField;
    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-zone']")
    WebElement stateField;
    @CacheLookup
    @FindBy(xpath = "//input[@id='button-guest']")
    WebElement continueButtonGuest;
    @CacheLookup
    @FindBy(name = "agree")
    WebElement termsAndCondition;
    @CacheLookup
    @FindBy(xpath = "//input[@id='button-payment-method']")
    WebElement continueButtonPayment;
    @CacheLookup
    @FindBy(xpath = "//div[text()='Warning: Payment method required!']")
    WebElement warningMessageText;
    @CacheLookup
    @FindBy(tagName = "textarea")
    WebElement textArea;

    public void enterFirstname() {
        sendTextToElement(firstNameField, "Smart");

    }

    public void enterLastName() {
        sendTextToElement(lastNameField, "Tester");

    }

    public void enterEmail() {
        sendTextToElement(emailField, "smarttester@gmail.com");
    }

    public void enterTelephone() {
        sendTextToElement(telephoneField, "123456789");
    }

    public void enterAddress() {
        sendTextToElement(addressField, "Millcar Drive");
    }

    public void enterCity() {
        sendTextToElement(cityField, "Toronto");
    }

    public void enterPostcode() {
        sendTextToElement(postcodeField, "M1B 6J5");
    }

    public void enterCountry() {
        sendTextToElement(countryField, "Canada");
        ;
    }

    public void enterState() {
        sendTextToElement(stateField, "ON");

    }

    public void clickContinueButtonguest() {
        clickOnElement(continueButtonGuest);
    }

    public void enterCommentInTextAea() {
        sendTextToElement(textArea, "Thank You!");
    }

    public void checkTermsAndConditionCheckBox() {
        clickOnElement(termsAndCondition);

    }

    public void clickContinueButtonPayment() {
        clickOnElement(continueButtonPayment);
    }

    public String GetWarningMessageText() {
        return getTextFromElement(warningMessageText);
    }

}
