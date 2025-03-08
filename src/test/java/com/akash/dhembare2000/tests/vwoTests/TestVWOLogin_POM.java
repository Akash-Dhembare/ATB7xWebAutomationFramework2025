package com.akash.dhembare2000.tests.vwoTests;

import com.akash.dhembare2000.base.CommonToAllPages;
import com.akash.dhembare2000.base.CommonToAllTests;
import com.akash.dhembare2000.driver.DriverManager;
import com.akash.dhembare2000.pages.pageObjectModel.LoginPage_POM;
import com.akash.dhembare2000.utils.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class TestVWOLogin_POM extends CommonToAllTests {


    private static final Logger logger = LogManager.getLogger(TestVWOLogin_POM.class);

    @Test
    public void testLoginVWONegative(){

        logger.info("Starting the Testcase");
        LoginPage_POM loginPagePom= new LoginPage_POM(DriverManager.getDriver());
        logger.info("Opening the URL");
        String error_msg_text=loginPagePom.logintoVWOInvalidCred(PropertyReader.readKey("invalid_username"), PropertyReader.readKey("invalid_password"));
        logger.info("Verifying the Username : "+error_msg_text);
        assertThat(error_msg_text).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg_text, PropertyReader.readKey("error_message"));
    }


}
