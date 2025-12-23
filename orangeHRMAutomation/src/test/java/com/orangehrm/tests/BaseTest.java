package com.orangehrm.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    protected Properties prop;
    protected Logger log = LogManager.getLogger(this.getClass());

    @BeforeMethod
    public void setup() throws IOException {
        log.info("===== Test Setup Started =====");
        prop = new Properties();
        FileInputStream fis = new FileInputStream("config/config.properties");
        prop.load(fis);

        String browser = prop.getProperty("browser", "chrome");
        log.info("Launching " + browser + " browser...");

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        log.info("Navigated to " + prop.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        log.info("Closing browser...");
        if (driver != null) {
            driver.quit();
        }
    }

    // Take screenshot and return relative path
    public String takeScreenshot(String testName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String destPath = "reports/screenshots/" + testName + "_" + timestamp + ".png";
            File destFile = new File(destPath);
            destFile.getParentFile().mkdirs();
            Files.copy(src.toPath(), destFile.toPath());
            return destPath;
        } catch (Exception e) {
            log.error("Failed to take screenshot: " + e.getMessage());
            return null;
        }
    }
}
