package tests;
import base.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.HomePage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NikeTestNavBar {
    public static void main(String[] args) {
        /*The next test
         will check whether the menu matches
         a list of strings that I defined as a menu.
         */
        System.out.println("test start");
        BaseDriver.setupDriver();
        WebDriver driver = BaseDriver.getDriver();

        // Navigating the Nike homepage.
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage();

        // Expected list of menu items
        List<String> expectedMenu = Arrays.asList("New & Featured", "Men", "Women", "Kids");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> menuElements = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("menu-hover-trigger-link"))
        );

        // Creating an actual list from the website
        List<String> actualMenu = new ArrayList<>();
        for (WebElement element : menuElements) {
            System.out.println(element.getText());
            actualMenu.add(element.getText().trim()); // הוספת הטקסט לרשימה
        }

        // Compare between the expected list and the actual list
        if (expectedMenu.equals(actualMenu)) {
            System.out.println("The menu matches the expected list.");
        } else {
            System.out.println("The menu does NOT match the expected list.");
            System.out.println("Expected: " + expectedMenu);
            System.out.println("Actual: " + actualMenu);
        }

        BaseDriver.closeDriver();
    }
}
