package com.DeepakSalla.tests.ui;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.DeepakSalla.framework.driver.WebDriverFactory;

public class ExampleUiTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = WebDriverFactory.getDriver();
    }

    @Test
    public void openExampleDotCom() {
        // Navigate to the simplest test site
        driver.get("https://example.com/");

        // Grab and print the title
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);

        // Basic sanity: title is exactly "Example Domain"
        assert "Example Domain".equals(title)
            : "Expected title to be 'Example Domain' but was: '" + title + "'";
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
