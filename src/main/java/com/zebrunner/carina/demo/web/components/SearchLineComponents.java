package com.zebrunner.carina.demo.web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class SearchLineComponents extends AbstractUIObject {

    @FindBy(xpath = ".//*[@id = \"search\"]")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = ".//button[@title = \"Search\"]")

    private ExtendedWebElement searchButton;

    public SearchLineComponents(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getSearchBar() {
        return searchBar;
    }

    public ExtendedWebElement getSearchButton() {
        return searchButton;
    }

    public void typeSearchInputValue (String value) {
        searchBar.click();
        searchBar.type(value);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public void clickSearchButton(){
        searchButton.hover();
        searchButton.click();
    }

}
