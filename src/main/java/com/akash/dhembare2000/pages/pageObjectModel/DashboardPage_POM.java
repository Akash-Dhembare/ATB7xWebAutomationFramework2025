package com.akash.dhembare2000.pages.pageObjectModel;

import com.akash.dhembare2000.base.CommonToAllPages;
import org.openqa.selenium.By;

public class DashboardPage_POM extends CommonToAllPages {
    public DashboardPage_POM() {
    }

    // Page Locators
    By usernameOnDashboard = By.xpath("//span[@data-qa='lufexuloga']");

    // Page Actions
    public String loggedInUsername(){
        presenseOfElement(usernameOnDashboard);
        return getElement(usernameOnDashboard).getText();
    }
}
