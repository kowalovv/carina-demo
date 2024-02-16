package com.zebrunner.carina.demo.androidExample.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class HomePage extends AbstractPage {

    private String baseUrl = "https://magento.softwaretestingboard.com/";

    @FindBy(xpath = "//*[@class = 'logo']/.")
    private ExtendedWebElement logo;

    @FindBy(xpath = "//a[contains(text(), 'Orders and Returns')]")
    private ExtendedWebElement ordersAndReturnsButton;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageAbsoluteURL(baseUrl);
    }

    public ExtendedWebElement getLogo() {
        return logo;
    }

    public ExtendedWebElement getOrdersAndReturnsButton() {
        return ordersAndReturnsButton;
    }


    public String getBaseUrl() {
        return baseUrl;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public OrdersAndReturnsPage goToOrdersTab(){
        ordersAndReturnsButton.click();
        return new OrdersAndReturnsPage(driver);
    }



}




