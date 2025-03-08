package com.akash.dhembare2000.driver;

import com.akash.dhembare2000.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    public static void init(){
        String browser = null;
        browser = PropertyReader.readKey("browser");
        browser = browser.toLowerCase();

        if (driver==null){
            switch (browser){
                case "edge":
                    EdgeOptions options = new EdgeOptions();
                    options.addArguments("--start-maximized");
                    options.addArguments("--InPrivate");
                    driver = new EdgeDriver(options);
                    break;

                case "chrome":
                    ChromeOptions options1= new ChromeOptions();
                    options1.addArguments("--start-maximized");
                    options1.addArguments("--Incognito");
                    driver = new ChromeDriver(options1);
                    break;

                case "firefox":
                    FirefoxOptions options2= new FirefoxOptions();
                    options2.addArguments("--start-maximized");
                    options2.addArguments("--Private");
                    driver = new FirefoxDriver(options2);
                    break;


                default:
                    System.out.println("No Browser Found!");
            }
        }

    }
    public static void down(){

        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
