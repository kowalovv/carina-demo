package com.zebrunner.carina.demo.web;

import com.zebrunner.carina.demo.web.components.ManTabComponents;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ManPage extends AbstractPage {

    @FindBy(xpath = "//*")
private ManTabComponents manTabComponents;

    public ManPage(WebDriver driver) {
        super(driver);
    }

    public ManTabComponents getManTabComponents() {
        return manTabComponents;
    }

    @Override
    public void open() {
        openURL("https://magento.softwaretestingboard.com/men.html");
    }
}

