package com.akash.dhembare2000.pages.pageObjectModel;

import com.akash.dhembare2000.base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage_POM extends CommonToAllPages {

    WebDriver driver;

    public LoginPage_POM(WebDriver driver) {
        this.driver = driver;
    }

    // Page Locators
    private By username = By.xpath("//input[@id='login-username']");
    private By password = By.xpath("//input[@id='login-password']");
    private By signin_button = By.xpath("//button[@id='js-login-btn']");
    private By error_message = By.xpath("//div[@id='js-notification-box-msg']");

    // Page Actions
    public String logintoVWOInvalidCred(String user, String pwd){
        driver.get("https://app.vwo.com/#/login");
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signin_button).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement error_msg= driver.findElement(By.xpath("//div[@id='js-notification-box-msg']"));
        String error_msg_text = error_msg.getText();
        String error_msg_attribute_data_qa = error_msg.getAttribute("data-qa");
        return error_msg_text;
    }


}
