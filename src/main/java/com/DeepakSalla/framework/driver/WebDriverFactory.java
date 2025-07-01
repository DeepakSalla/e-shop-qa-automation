package com.DeepakSalla.framework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {

    /**
     * Uses Selenium Manager to auto-resolve ChromeDriver.
     */
    public static WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions();
        // any options you need, e.g. headless:
        // options.addArguments("--headless=new");
        return new ChromeDriver(options);
    }
}
