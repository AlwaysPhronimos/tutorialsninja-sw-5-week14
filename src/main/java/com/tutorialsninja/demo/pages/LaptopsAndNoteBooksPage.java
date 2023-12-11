package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNoteBooksPage extends Utility {
    @CacheLookup
    @FindBy(linkText = "Show AllLaptops & Notebooks")
    WebElement clickOnShowAllLaptopsandNoteBooks;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortByPrice;

    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement macbookClick;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'MacBook')]")
    WebElement macbookText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successText;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement cartButton;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartLink;

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement shoppingCartText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement macbooknameText;

    @CacheLookup
    @FindBy(xpath = "//tbody/tr[1]/td[4]/div[1]/input[1]")
    WebElement clearQty;

    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement changeQty;

    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement updatetab;

    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement modifiedSuccessText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement totalText;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    WebElement checkoutLink;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Checkout')]")
    WebElement checkoutText;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'New Customer')]")
    WebElement newCustomerText;

    @CacheLookup
    @FindBy(xpath = "//input[@value='guest']")
    WebElement guestCheckoutButton;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-account']")
    WebElement continueLink;

    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    List<WebElement> priceList;

    public void clickOnShowAllLaptopAndNoteBooks() {
        clickOnElement(clickOnShowAllLaptopsandNoteBooks);
    }
    public void originalProductPrice() {
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);
    }

    public void sortByPriceHighToLow() {
        selectByVisibleTextFromDropDown(sortByPrice, "Price (High > Low)");
    }

    public void afterSortByPrice() {
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(afterSortByPrice);
    }

    public void clickOnMacbook() {
        clickOnElement(macbookClick);
    }

    public String getMacbookText() {
        return getTextFromElement(macbookText);
    }

    public void addToCart() {
        clickOnElement(cartButton);
    }

    public String getSuccessText() {
        return getTextFromElement(successText);
    }

    public void clickShoppingCart() {
        clickOnElement(shoppingCartLink);
    }

    public String getShoppingCartText() {
        return getTextFromElement(shoppingCartText);
    }

    public String getMacbookNameText() {
        return getTextFromElement(macbooknameText);
    }

    public void clearQty() {
        clearQty.clear();
    }

    public void changeQty() {
        sendTextToElement(changeQty, "2");
    }

    public void clickUpdateTab() {
        clickOnElement(updatetab);
    }

    public String getModifiedSuccessText() {
        return getTextFromElement(modifiedSuccessText);
    }

    public String getTotalText() {
        return getTextFromElement(totalText);
    }

    public void clickCheckout() {
        clickOnElement(checkoutLink);
    }

    public String getCheckoutText() {
        return getTextFromElement(checkoutText);
    }

    public String getNewCustomerText() {
        return getTextFromElement(newCustomerText);
    }

    public void clickOnGuestCheckoutButton() {
        clickOnElement(guestCheckoutButton);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueLink);
    }
}
