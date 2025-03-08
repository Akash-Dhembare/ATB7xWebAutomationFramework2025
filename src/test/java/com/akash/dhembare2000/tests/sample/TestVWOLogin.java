package com.akash.dhembare2000.tests.sample;

import com.akash.dhembare2000.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestVWOLogin {

    @BeforeTest
    public void setUp(){
        DriverManager.init();
    }
    @Test
    public void testLogin(){


//        EdgeOptions options= new EdgeOptions();
//        options.addArguments("--start-maximized");

        WebDriver driver= DriverManager.getDriver();
       // WebDriver driver= new EdgeDriver(options);
        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");


        WebElement emailInputBox = driver.findElement(By.id("login-username")); // Page Locator
        emailInputBox.sendKeys("admin@admin.com"); // Page Action

        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("admin");

        driver.findElement(By.id("js-login-btn")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement error_msg = driver.findElement(By.className("notification-box-description"));
        String error_msg_text = error_msg.getText();
        String error_msg_attribute_dataqa = error_msg.getAttribute("data-qa");
        System.out.println(error_msg_attribute_dataqa);

        Assert.assertEquals(error_msg_text, "Your email, password, IP address or location did not match");
        driver.quit();

    }
}
