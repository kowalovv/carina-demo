package com.zebrunner.carina.demo.web;

import com.zebrunner.carina.demo.web.components.FooterComponent;
import com.zebrunner.carina.demo.web.components.Header;
import com.zebrunner.carina.demo.web.components.MenuComponent;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//header")
    private Header header;

    @FindBy(xpath = "//div[@class='footer content']")
    private FooterComponent footerComponent;

    @FindBy(xpath = "//ul[@id ='ui-id-2']")
    private MenuComponent menuComponent;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public FooterComponent getFooterComponents() {
        return footerComponent;
    }

    public MenuComponent getMenuComponents() {
        return menuComponent;
    }

    public Header getHeader() {
        return header;
    }

    @Override
    public void open() {
        openURL(Configuration.getRequired("home_url"));
    }

    public void switchTab(){
        String homeWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(homeWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }
}
