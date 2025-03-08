package com.akash.dhembare2000.tests.vwoTests;

import com.akash.dhembare2000.base.CommonToAllTests;
import com.akash.dhembare2000.driver.DriverManager;
import com.akash.dhembare2000.pages.pageFactory.LoginPage_PF;
import com.akash.dhembare2000.pages.pageObjectModel.LoginPage_POM;
import com.akash.dhembare2000.utils.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin_PF extends CommonToAllTests {


    private static final Logger logger = LogManager.getLogger(TestVWOLogin_PF.class);


    @Test
    public void testLoginNegativeVWO_PF() {
        logger.info("Starting the Testcases Page Factory");
        WebDriver driver = DriverManager.getDriver();
        driver.get(PropertyReader.readKey("url"));
        LoginPage_PF loginPage_PF = new LoginPage_PF(driver);
        String error_msg = loginPage_PF.loginToVWOInvalidCreds();
        Assert.assertEquals(error_msg, PropertyReader.readKey("error_message"));
    }


}
