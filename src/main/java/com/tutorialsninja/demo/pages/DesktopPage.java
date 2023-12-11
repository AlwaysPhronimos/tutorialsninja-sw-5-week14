package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopPage extends Utility {
    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement mouseHoverDesktop;

    @CacheLookup
    @FindBy(linkText = "Show AllDesktops")
    WebElement clickDesktop;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement selectSortZToA;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement selectSortAToZ;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'HP LP3065')]")
    WebElement selectProduct;

    @CacheLookup
    @FindBy(name = "quantity")
    WebElement enterQty;

    @CacheLookup
    @FindBy(id = "button-cart")
    WebElement addToCartClick;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'HP LP3065')]")
    WebElement hpText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successText;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Shopping Cart')]")
    WebElement shoppingcartText;

    @CacheLookup
    @FindBy(xpath = "(//a[text()='HP LP3065'])[2]")
    WebElement hpProductText;
    @CacheLookup
    @FindBy(xpath = "//td[normalize-space()='Product 21']")
    WebElement product21Text;

    @CacheLookup
    @FindBy(xpath = "(//td[@class='text-right'][normalize-space()='£74.73'])[4]")
    WebElement totalcostText;

    @CacheLookup
    @FindBy(xpath = "//small[normalize-space()='Delivery Date:2023-11-30']")
    WebElement deliveryDateText;

    public void selectSortByAToZ() {
        selectByVisibleTextFromDropDown(selectSortAToZ, "Name (A - Z)");
    }

    public void mouseHoverAndClickDesktops() {
        mouseHoverToElementAndClick(mouseHoverDesktop);
    }

    public void clickOnShowAllDeskTops() {
        clickOnElement(clickDesktop);
    }

    public void selectSortByZToA() {
        selectByVisibleTextFromDropDown(selectSortZToA, "Name (Z - A)");
    }

    public void selectProduct() {
        clickOnElement(selectProduct);
    }

    public void addToCart() {
        clickOnElement(addToCartClick);
    }

    public String getHPText() {
        return getTextFromElement(hpText);
    }

    public String getSuccessMessageText() {
        return getTextFromElement(successText);
    }

    public String getShoppingCartText() {
        return getTextFromElement(shoppingcartText);
    }

    public String getHPProdcutText() {
        return getTextFromElement(hpProductText);
    }

    public String getProduct21Text() {
        return getTextFromElement(product21Text);
    }

    public String getTotalCostText() {
        return getTextFromElement(totalcostText);
    }

    public String getDeliveryDateText() {
        return getTextFromElement(deliveryDateText);
    }

    public void verifyProductArrangeInDescendingOrder() {
        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);
    }

    public void selectDeliveryDate() {
        String year = "2023";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }
}
