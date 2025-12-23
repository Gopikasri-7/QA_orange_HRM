package com.orangehrm.tests;

import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void validLoginTest() throws InterruptedException {
        log.info("=== Valid Login Test ===");
        LoginPage login = new LoginPage(driver);
        DashboardPage dashboard = login.loginValidUser(prop.getProperty("username"), prop.getProperty("password"));
        Assert.assertTrue(dashboard.isDashboardDisplayed(), "Dashboard not visible!");
        log.info("Valid login successful");
    }

    @Test(priority = 2)
    public void invalidLoginTest() throws InterruptedException {
        log.info("=== Invalid Login Test ===");
        LoginPage login = new LoginPage(driver);
        login.loginInvalidUser("WrongUser", "WrongPass");
        String error = login.getErrorMessage();
        Assert.assertTrue(error.toLowerCase().contains("invalid"), "Expected invalid credentials message");
        log.info("Error message displayed correctly");
    }

    @Test(priority = 3)
    public void logoutTest() throws InterruptedException {
        log.info("=== Logout Test ===");
        LoginPage login = new LoginPage(driver);
        DashboardPage dashboard = login.loginValidUser(prop.getProperty("username"), prop.getProperty("password"));
        dashboard.clickUserDropdown();
        dashboard.clickLogout();

        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"), "Not redirected to login page after logout");
        log.info("Logout successful");
    }
}
