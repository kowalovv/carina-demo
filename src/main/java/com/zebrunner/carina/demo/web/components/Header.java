package com.zebrunner.carina.demo.web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {

    @FindBy(xpath = "//*[@class = 'logo']")
    private ExtendedWebElement logo;

    @FindBy(xpath = ".//div[@class = 'block block-search']")
    private SearchLineComponent searchLineComponent;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public ExtendedWebElement getLogo() {
        return logo;
    }

    public SearchLineComponent getSearchLineComponent() {
        return searchLineComponent;
    }
}


