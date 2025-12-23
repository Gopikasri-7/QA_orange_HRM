package com.orangehrm.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class LoginPage {
    private WebDriver driver;
    private Logger log = LogManager.getLogger(this.getClass());

    private By username = By.name("username");
    private By password = By.name("password");
    private By loginBtn = By.cssSelector("button[type='submit']");
    private By errorMsg = By.xpath("//p[contains(@class,'oxd-alert-content-text')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String user) {
        log.info("Entering username: " + user);
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
    }

    public void setPassword(String pass) {
        log.info("Entering password");
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() throws InterruptedException {
        log.info("Clicking on Login button");
        driver.findElement(loginBtn).click();
        Thread.sleep(4000);
    }

    public com.orangehrm.pages.DashboardPage loginValidUser(String user, String pass) throws InterruptedException {
        Thread.sleep(4000);
        setUsername(user);
        setPassword(pass);
        clickLogin();
        return new com.orangehrm.pages.DashboardPage(driver);
    }

    public void loginInvalidUser(String user, String pass) throws InterruptedException {
        Thread.sleep(4000);
        setUsername(user);
        setPassword(pass);
        clickLogin();
    }

    public String getErrorMessage() {
        try {
            return driver.findElement(errorMsg).getText();
        } catch (Exception e) {
            return "";
        }
    }
}
