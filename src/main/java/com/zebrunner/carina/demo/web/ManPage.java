package com.zebrunner.carina.demo.web;

import com.zebrunner.carina.demo.web.components.ManTabComponent;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ManPage extends AbstractPage {

    @FindBy(xpath = "//body")
    private ManTabComponent manTabComponent;

    public ManPage(WebDriver driver) {
        super(driver);
    }

    public ManTabComponent getManTabComponents() {
        return manTabComponent;
    }

    @Override
    public void open() {
        openURL("https://magento.softwaretestingboard.com/men.html");
    }
}

