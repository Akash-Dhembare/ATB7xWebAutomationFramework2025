package com.akash.dhembare2000.pages.pageFactory;

import com.akash.dhembare2000.base.CommonToAllPages;
import com.akash.dhembare2000.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class LoginPage_PF extends CommonToAllPages {
    public LoginPage_PF(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Page Locators

    @FindBy(xpath = "//input[@id='login-username']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='login-password']")
    private WebElement password;

    @FindBy(xpath = "//button[@id='js-login-btn']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@id='js-notification-box-msg']")
    private WebElement errorMessage;


    // Page Actions
    public String loginToVWOInvalidCreds(){
        enterInput(username, PropertyReader.readKey("invalid_username"));
        enterInput(password, PropertyReader.readKey("invalid_password"));
        clickElement(signInButton);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return errorMessage.getText();
    }
}
