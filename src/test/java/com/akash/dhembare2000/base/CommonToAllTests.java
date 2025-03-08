package com.akash.dhembare2000.base;

import com.akash.dhembare2000.driver.DriverManager;
import com.akash.dhembare2000.pages.pageObjectModel.LoginPage_POM;
import com.akash.dhembare2000.utils.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CommonToAllTests {
    @BeforeTest
    public void setUp(){
        DriverManager.init();
    }


    @AfterTest
    public void tearDown(){
        DriverManager.down();
    }
}
