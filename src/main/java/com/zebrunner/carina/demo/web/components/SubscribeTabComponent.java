package com.zebrunner.carina.demo.web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SubscribeTabComponent extends AbstractUIObject {

    @FindBy(xpath = ".//input[@id= 'mc-embedded-subscribe']")
    private ExtendedWebElement subscribeButton;

    @FindBy(xpath = ".//input[@type= 'email']")
    private ExtendedWebElement mailInput;

    @FindBy(xpath = ".//*[@id='mce-success-response']")
    private ExtendedWebElement successInfo;

    public SubscribeTabComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getSuccessInfo() {
        return successInfo;
    }

    public ExtendedWebElement getMailInput() {
        return mailInput;
    }

    public ExtendedWebElement getSubscribeButton() {
        return subscribeButton;
    }

    public void typeInputValue (String value) {
        mailInput.click();
        mailInput.type(value);
    }
}
