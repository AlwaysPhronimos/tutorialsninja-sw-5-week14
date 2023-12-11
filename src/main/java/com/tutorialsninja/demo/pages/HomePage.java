package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement mouseHoverDesktop;

    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement mouseHoverLaptopsAndNotebooks;

    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement mouseHoverComponents;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement desktopText;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopNotebookText;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Components')]")
    WebElement componentsText;

    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    List<WebElement> selectMenu1;

    public void selectMenu(String menu) {
        try {
            List<WebElement> list = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
            for (WebElement listOfElement : list) {
                if (listOfElement.getText().equals(menu)) {
                    listOfElement.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            List<WebElement> list = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        }
    }

    public String getDesktopText() {
        return getTextFromElement(desktopText);
    }

    public String getLaptopsNotebooksText() {
        return getTextFromElement(laptopNotebookText);
    }

    public String getComponents() {
        return getTextFromElement(componentsText);
    }

    public void mouseHoverAndClickDesktops() {
        mouseHoverToElementAndClick(mouseHoverDesktop);
    }

    public void mouseHoverAndClickLaptopsAndNotebooks() {
        mouseHoverToElementAndClick(mouseHoverLaptopsAndNotebooks);

    }

    public void mouseHoverAndClickComponents() {
        mouseHoverToElementAndClick(mouseHoverComponents);
    }
}
