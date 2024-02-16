package com.zebrunner.carina.demo.androidExample.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class OrdersAndReturnsPage extends AbstractPage {

    private String baseUrl = "https://magento.softwaretestingboard.com/sales/guest/form/";

    @FindBy(xpath = "//input[@id = 'oar-order-id']")
    private ExtendedWebElement orderId;

    @FindBy(xpath = "//input[@id = 'oar-billing-lastname']")
    private ExtendedWebElement lastName;

    @FindBy(xpath = "//input[@id = 'oar_email']")
    private ExtendedWebElement mail;

    @FindBy(xpath = "//div//button[@title= 'Continue']")
    private ExtendedWebElement continueButton;

    @FindBy(xpath = "//div[@class = 'message-error error message']")
    private ExtendedWebElement errorMessage;

    @FindBy(id = "oar-order-id-error")
    private ExtendedWebElement emptyIdError;

    public OrdersAndReturnsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageAbsoluteURL(baseUrl);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public ExtendedWebElement getOrderId() {
        return orderId;
    }

    public ExtendedWebElement getLastName() {
        return lastName;
    }

    public ExtendedWebElement getMail() {
        return mail;
    }

    public ExtendedWebElement getContinueButton() {
        return continueButton;
    }

    public ExtendedWebElement getErrorMessage() {
        return errorMessage;
    }

    public ExtendedWebElement getEmptyIdError() {
        return emptyIdError;
    }

    public void typeNotValidData(){
        orderId.type("123");
        lastName.type("Doe");
        mail.type("dsa@gm.com");
        continueButton.click();
    }

    public void typeDataWithoutId(){
        lastName.type("Doe");
        mail.type("dsa@gm.com");
        continueButton.click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}
