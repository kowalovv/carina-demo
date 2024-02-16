package com.zebrunner.carina.demo.mobileTest;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.androidExample.pages.CreateAccountPage;
import com.zebrunner.carina.demo.androidExample.pages.HomePage;
import com.zebrunner.carina.demo.androidExample.pages.OrdersAndReturnsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;


public class AndroidTests implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @Test(description = "DEMO-1")
    @MethodOwner(owner = "Patryk")
    public void openHomePageTest() {
        LOGGER.info("Test 1");
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertEquals(homePage.getCurrentUrl(), homePage.getBaseUrl(), "Home page doesn't open");
    }

    @Test(description = "DEMO-2")
    @MethodOwner(owner = "Patryk")
    public void redirectionFromLogoTest() {
        LOGGER.info("Test 2");
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.getLogo().click();
        Assert.assertEquals(homePage.getCurrentUrl(), homePage.getBaseUrl(), "The logo after click doesn't redirect to the Home page");
    }

    @Test(description = "DEMO-3")
    @MethodOwner(owner = "Patryk")
    public void createAccountWithValidDataTest() {
        LOGGER.info("Test 3");
        CreateAccountPage accountPage = new CreateAccountPage(getDriver());
        accountPage.open();
        accountPage.typeValidData();
        Assert.assertEquals(accountPage.getCurrentUrl(), accountPage.getLoggedInUrl(),
                "After creating an account, the browser doesn't redirect to the user's website");
        Assert.assertTrue(accountPage.getSuccessMessage().isElementPresent(), "Success message doesn't display");
    }

    @Test(description = "DEMO-4")
    @MethodOwner(owner = "Patryk")
    public void createAccountWithExistingDataTest() {
        LOGGER.info("Test 4");
        CreateAccountPage accountPage = new CreateAccountPage(getDriver());
        accountPage.open();
        accountPage.typeExistingData();
        Assert.assertNotEquals(accountPage.getCurrentUrl(), accountPage.getLoggedInUrl(), "The browser redirects to the user's website");
        Assert.assertFalse(accountPage.getSuccessMessage().isElementPresent(), "Success message is displayed");
    }

    @Test(description = "DEMO-5")
    @MethodOwner(owner = "Patryk")
    public void createAccountWithIncompatiblePasswordsTest() {
        LOGGER.info("Test 5");
        CreateAccountPage accountPage = new CreateAccountPage(getDriver());
        accountPage.open();
        accountPage.typeDataWithIncompatiblePasswords();
        Assert.assertNotEquals(accountPage.getCurrentUrl(), accountPage.getLoggedInUrl(),
                "The browser redirects to the user's website");
        Assert.assertFalse(accountPage.getSuccessMessage().isElementPresent(), "Success message is displayed");
    }

    @Test(description = "DEMO-6")
    @MethodOwner(owner = "Patryk")
    public void logoClickActionFromCreateAccountTabTest() {
        LOGGER.info("Test 6");
        CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
        createAccountPage.open();
        HomePage homePage = new HomePage(getDriver());
        homePage.getLogo().click();
        Assert.assertEquals(homePage.getCurrentUrl(), homePage.getBaseUrl(), "Page doesn't returned to the home page");
    }

    @Test(description = "DEMO-7")
    @MethodOwner(owner = "Patryk")
    public void redirectionToTheOrdersAndReturnsPageFromHomePageTest() {
        LOGGER.info("Test 7");
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        OrdersAndReturnsPage ordersPage = homePage.goToOrdersTab();
        Assert.assertEquals(ordersPage.getCurrentUrl(), ordersPage.getBaseUrl(), "Orders and returns page doesn't displayed");
    }

    @Test(description = "DEMO-8")
    @MethodOwner(owner = "Patryk")
    public void searchOrdersWithNotValidDataTest() {
        LOGGER.info("Test 8");
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        OrdersAndReturnsPage ordersPage = homePage.goToOrdersTab();
        Assert.assertEquals(ordersPage.getCurrentUrl(), ordersPage.getBaseUrl(), "Orders and returns page doesn't displayed");
        ordersPage.typeNotValidData();
        Assert.assertTrue(ordersPage.getErrorMessage().isElementPresent(), "Error doesn't appear");
    }

    @Test(description = "DEMO-9")
    @MethodOwner(owner = "Patryk")
    public void searchOrdersWithIdNumberEmptyTest() {
        LOGGER.info("Test 9");
        OrdersAndReturnsPage ordersPage = new OrdersAndReturnsPage(getDriver());
        ordersPage.open();
        ordersPage.typeDataWithoutId();
        Assert.assertEquals(ordersPage.getCurrentUrl(), ordersPage.getBaseUrl(), "The page was redirected");
        Assert.assertTrue(ordersPage.getEmptyIdError().isElementPresent(), "No empty field error was displayed");
    }

    @Test(description = "DEMO-10")
    @MethodOwner(owner = "Patryk")
    public void basicFunctionalityTest() {
        LOGGER.info("Test 10");
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        OrdersAndReturnsPage ordersPage = homePage.goToOrdersTab();
        Assert.assertEquals(driver.getCurrentUrl(), ordersPage.getBaseUrl(), "The page wasn't redirected");
        ordersPage.typeNotValidData();
        homePage.getLogo().click();
        Assert.assertEquals(driver.getCurrentUrl(), homePage.getBaseUrl(), "The page wasn't redirected");
        CreateAccountPage accountPage = new CreateAccountPage(driver);
        accountPage.open();
        Assert.assertEquals(driver.getCurrentUrl(), accountPage.getBaseUrl(), "The page wasn't redirected");
        accountPage.typeValidData();
        Assert.assertEquals(accountPage.getCurrentUrl(), accountPage.getLoggedInUrl(),
                "After creating an account, the browser doesn't redirect to the user's website");
        Assert.assertTrue(accountPage.getSuccessMessage().isElementPresent(), "Success message doesn't display");
    }


    @BeforeTest
    @Override
    public WebDriver getDriver() {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "android");
        dc.setCapability("appium:automationName", "uiautomator2");
        dc.setCapability("appium:deviceName", "Pixel 3 API 30");
        dc.setCapability("appium:deviceType", "phone");
        dc.setCapability("appium:udid", "emulator-5554");
        dc.setCapability("browserName", "chrome");
        return getDriver("default", dc);

    }
}
