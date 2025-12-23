package com.orangehrm.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;
    private Logger log = LogManager.getLogger(this.getClass());

    private By dashboardTitle = By.xpath("//h6[text()='Dashboard']");
    private By userDropdown = By.cssSelector("p.oxd-userdropdown-name");
    private By logoutOption = By.xpath("//a[text()='Logout']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDashboardDisplayed() {
        log.info("Verifying Dashboard visibility...");
        try {
            return driver.findElement(dashboardTitle).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickUserDropdown() {
        log.info("Clicking user dropdown...");
        driver.findElement(userDropdown).click();
    }

    public void clickLogout() {
        log.info("Clicking Logout...");
        driver.findElement(logoutOption).click();
    }
}
