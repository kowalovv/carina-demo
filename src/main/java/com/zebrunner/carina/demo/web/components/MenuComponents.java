package com.zebrunner.carina.demo.web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MenuComponents  extends AbstractUIObject {

    @FindBy(xpath = ".//a[@id=\"ui-id-5\"]")
    ExtendedWebElement manButton;


    public MenuComponents(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getManButton() {
        return manButton;
    }
}
