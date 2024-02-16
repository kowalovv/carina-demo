package com.zebrunner.carina.demo.androidExample.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class CreateAccountPage extends AbstractPage {

    private String baseUrl = "https://magento.softwaretestingboard.com/customer/account/create/";

    private String loggedInUrl = "https://magento.softwaretestingboard.com/customer/account/";

    @FindBy(id = "firstname")
    private ExtendedWebElement firstName;
    @FindBy(id = "lastname")
    private ExtendedWebElement lastName;
    @FindBy(id = "email_address")
    private ExtendedWebElement mail;
    @FindBy(id = "password")
    private ExtendedWebElement password;
    @FindBy(id = "password-confirmation")
    private ExtendedWebElement confirmPassword;

    @FindBy(xpath = "//button [@title= 'Create an Account']")
    private ExtendedWebElement createAccountButton;

    @FindBy(xpath = "//div[@class='message-success success message']")
    private ExtendedWebElement successMessage;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageAbsoluteURL(baseUrl);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getLoggedInUrl() {
        return loggedInUrl;
    }

    public ExtendedWebElement getFirstName() {
        return firstName;
    }

    public ExtendedWebElement getLastName() {
        return lastName;
    }

    public ExtendedWebElement getMail() {
        return mail;
    }

    public ExtendedWebElement getPassword() {
        return password;
    }

    public ExtendedWebElement getConfirmPassword() {
        return confirmPassword;
    }

    public ExtendedWebElement getCreateAccountButton() {
        return createAccountButton;
    }

    public ExtendedWebElement getSuccessMessage() {
        return successMessage;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void typeValidData() {
        String random = generateRandomString(5);
        firstName.type(random);
        lastName.type(random);
        String testPassword = "123aSd123a@d2";
        mail.type(random + "@gmail.com");
        password.type(testPassword);
        confirmPassword.type(testPassword);
        createAccountButton.click();
    }

    public void typeDataWithIncompatiblePasswords() {
        String random = generateRandomString(5);
        firstName.type(random);
        lastName.type(random);
        String testPassword = "123aSd123a@d2";
        mail.type(random + "@gmail.com");
        password.type(testPassword);
        confirmPassword.type(testPassword + "xxx");
        createAccountButton.click();
    }

    public void typeExistingData() {
        String random = generateRandomString(5);
        firstName.type("Patryk");
        lastName.type("Kowal");
        String testPassword = "123aS@@23a@d2";
        mail.type("kowal@gmail.com");
        password.type(testPassword);
        confirmPassword.type(testPassword);
        createAccountButton.click();
    }

    private String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomAscii = random.nextInt(26) + 97;
            char randomChar = (char) randomAscii;
            sb.append(randomChar);
        }
        return sb.toString();

    }
}
