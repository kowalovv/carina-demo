package com.zebrunner.carina.demo.web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class ManTabComponents extends AbstractUIObject {

    @FindBy(xpath = ".//a[@class=\"action showcart\"]")
    ExtendedWebElement showCart;

    @FindBy(xpath = ".//div[@id=\"option-label-size-143-item-169\"]")
    ExtendedWebElement randomSize;

    @FindBy(xpath = ".//div[@id=\"option-label-color-93-item-52\" and @index=\"0\"]")
    ExtendedWebElement randomColor;

    @FindBy(xpath = ".//a[@class=\"action showcart\"]//span[@class=\"counter-number\" and text()='1']")
    ExtendedWebElement showCartWithValue1;

    @FindBy(xpath = ".//button[@type=\"submit\" and @title=\"Add to Cart\"]")
    ExtendedWebElement addToCartButton;

    @FindBy(xpath = ".//a[@title=\"Remove item\"]")
    ExtendedWebElement removeFromCartButton;


    public ExtendedWebElement getShowCartWithValue1() {
        return showCartWithValue1;
    }

    public ManTabComponents(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public ExtendedWebElement getShowCart() {
        return showCart;
    }

    public ExtendedWebElement getAddToCartButton() {
        return addToCartButton;
    }

    public ExtendedWebElement getRemoveFromCartButton() {
        return removeFromCartButton;
    }

    public ExtendedWebElement getRandomSize() {
        return randomSize;
    }

    public ExtendedWebElement getRandomColor() {
        return randomColor;
    }

    public void addToCartItemFromManPage() {
        randomColor.click();
        randomSize.click();
            randomColor.hover();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            addToCartButton.click();
    }

    public void removeFromCartFromManPage() {
        showCart.click();
        removeFromCartButton.click();
        driver.findElement(By.xpath("//button[@class=\"action-primary action-accept\"]")).sendKeys(Keys.ENTER);
    }
}
