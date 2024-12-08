package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebUtils {

    // Method to wait for an element to be visible
    public static void waitForElement(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Method to click on an element
    public static void clickElement(WebElement element) {
        element.click();
    }

    // Method to enter text into an input field
    public static void enterText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    // Method to get the text of an element
    public static String getElementText(WebElement element) {
        return element.getText();
    }
}
