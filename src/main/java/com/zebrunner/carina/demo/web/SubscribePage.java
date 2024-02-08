package com.zebrunner.carina.demo.web;

import com.zebrunner.carina.demo.web.components.SubscribeTabComponents;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SubscribePage extends AbstractPage {


    @FindBy(xpath = "//*")
    private SubscribeTabComponents subscribeTabComponents;

    public SubscribePage(WebDriver driver) {
        super(driver);
    }

    public SubscribeTabComponents getSubscribeTabComponents() {
        return subscribeTabComponents;
    }

    @Override
    public void open() {
        openURL("https://softwaretestingboard.com/subscribe/");
    }
}
