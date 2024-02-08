package com.zebrunner.carina.demo.webTest;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.web.HomePage;
import com.zebrunner.carina.demo.web.ManPage;
import com.zebrunner.carina.demo.web.components.SearchLineComponents;
import com.zebrunner.carina.demo.web.SubscribePage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;
import java.util.Set;


public class MagentoTests extends AbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test(description = "DEMO-1")
    @MethodOwner(owner = "Patryk")
    public void searchLineBasicTest() {
        LOGGER.info("Test 1");
        WebDriver driver = getDriver();
        SoftAssert sa = new SoftAssert();
        HomePage homePage = new HomePage(driver);

        homePage.open();
        SearchLineComponents searchLineComponent = homePage.getHeader().getSearchLineComponent();
        sa.assertTrue(searchLineComponent.getSearchBar().isElementPresent(1), "Search bar is not present");
        String testWordWithoutSpace = "HelloWorld";
        String format = String.format("https://magento.softwaretestingboard.com/catalogsearch/result/?q=%s", testWordWithoutSpace);
        searchLineComponent.typeSearchInputValue(testWordWithoutSpace);
        sa.assertTrue(searchLineComponent.getSearchButton().isElementPresent(1), "Search button is not present");
        searchLineComponent.clickSearchButton();
        Assert.assertEquals(driver.getCurrentUrl(), format);
        sa.assertAll();
    }

    @Test(description = "DEMO-2")
    @MethodOwner(owner = "Patryk")
    public void logoClickActionRedirectionToHomePageTest() {
        LOGGER.info("Test 2");
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);

        homePage.open();
        String homeUrl = driver.getCurrentUrl();
        homePage.getHeader().getLogo().click();
        Assert.assertEquals(driver.getCurrentUrl(), homeUrl);
    }

    @Test(description = "DEMO-3")
    @MethodOwner(owner = "Patryk")
    public void notesClickActionRedirectToNewTabTest() {
        LOGGER.info("Test 3");
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);

        homePage.open();
        homePage.getFooterComponents().getNotes().click();
        String homeWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(homeWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        String notesWindowHandle = driver.getWindowHandle();
        Assert.assertNotEquals(homeWindowHandle, notesWindowHandle);
    }

    @Test(description = "DEMO-4")
    @MethodOwner(owner = "Patryk")
    public void redirectionToSubscribeFormTest() {
        LOGGER.info("Test 4");
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);

        homePage.open();
        homePage.getFooterComponents().getSubscribeLinkButton().click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://softwaretestingboard.com/subscribe/");
    }

    @Test(description = "DEMO-5")
    @MethodOwner(owner = "Patryk")
    public void subscribeWithoutMailValueTest() {
        LOGGER.info("Test 5");
        WebDriver driver = getDriver();
        SubscribePage subscribePage = new SubscribePage(driver);
        subscribePage.open();

        subscribePage.getSubscribeTabComponents().getSubscribeButton().click();
        Assert.assertFalse(subscribePage.getSubscribeTabComponents().getSuccessInfo().isElementPresent());
    }

    @Test(description = "DEMO-6")
    @MethodOwner(owner = "Patryk")
    public void subscribeWithValidMailValueTest() {
        LOGGER.info("Test 6");
        WebDriver driver = getDriver();
        SubscribePage subscribePage = new SubscribePage(driver);
        subscribePage.open();
        subscribePage.getSubscribeTabComponents().typeInputValue("kow@gmail.com");
        subscribePage.getSubscribeTabComponents().getSubscribeButton().click();
        Assert.assertTrue(subscribePage.getSubscribeTabComponents().getSuccessInfo().isElementPresent());
    }

    @Test(description = "DEMO-7")
    @MethodOwner(owner = "Patryk")
    public void subscribeWithNotValidMailValueTest() {
        LOGGER.info("Test 7");
        WebDriver driver = getDriver();
        SubscribePage subscribePage = new SubscribePage(driver);
        subscribePage.open();
        subscribePage.getSubscribeTabComponents().typeInputValue("kowal.gmail.com");
        subscribePage.getSubscribeTabComponents().getSubscribeButton().click();
        Assert.assertFalse(subscribePage.getSubscribeTabComponents().getSuccessInfo().isElementPresent());
    }

    @Test(description = "DEMO-8")
    @MethodOwner(owner = "Patryk")
    public void redirectionToManPageFromHomePageTest() {
        LOGGER.info("Test 8");
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.getMenuComponents().getManButton().click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://magento.softwaretestingboard.com/men.html");
    }

    @Test(description = "DEMO-9")
    @MethodOwner(owner = "Patryk")
    public void cartLogoPrintValueTest() {
        LOGGER.info("Test 9");
        WebDriver driver = getDriver();
        ManPage manPage = new ManPage(driver);
        manPage.open();
        manPage.getManTabComponents().addToCartItemFromManPage();
        Assert.assertTrue(manPage.getManTabComponents().getShowCartWithValue1().isElementPresent());
    }

    @Test(description = "DEMO-10")
    @MethodOwner(owner = "Patryk")
    public void deleteFromCartLogoTest() {
        LOGGER.info("Test 10");
        WebDriver driver = getDriver();
        SoftAssert sa = new SoftAssert();
        ManPage manPage = new ManPage(driver);
        manPage.open();
        manPage.getManTabComponents().addToCartItemFromManPage();
        sa.assertTrue(manPage.getManTabComponents().getShowCartWithValue1().isElementPresent());

        manPage.getManTabComponents().removeFromCartFromManPage();
        Assert.assertFalse(manPage.getManTabComponents().getShowCartWithValue1().isElementPresent());
        sa.assertAll();
    }




}
