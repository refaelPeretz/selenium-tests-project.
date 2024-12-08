package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseDriver {

    public static WebDriver driver;


    public static void setupDriver() {
        // ChromeDriver auto-start
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    // Method to quit the WebDriver
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
