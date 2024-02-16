package com.zebrunner.carina.demo.web;

import com.zebrunner.carina.demo.web.components.SubscribeTabComponent;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SubscribePage extends AbstractPage {


    @FindBy(xpath = "//body")
    private SubscribeTabComponent subscribeTabComponent;

    public SubscribePage(WebDriver driver) {
        super(driver);
    }

    public SubscribeTabComponent getSubscribeTabComponents() {
        return subscribeTabComponent;
    }

    @Override
    public void open() {
        openURL("https://softwaretestingboard.com/subscribe/");
    }
}
