package com.zebrunner.carina.demo.web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FooterComponents extends AbstractUIObject {

    @FindBy(xpath = ".//a[@target=\"_blank\"]")
    private ExtendedWebElement notes;

    @FindBy(xpath = ".//a[contains(@href, \"subscribe\")]")
    private ExtendedWebElement subscribeLinkButton;

    public ExtendedWebElement getSubscribeLinkButton() {
        return subscribeLinkButton;
    }

    public ExtendedWebElement getNotes() {
        return notes;
    }

    public FooterComponents(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

}
