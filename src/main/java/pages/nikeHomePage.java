package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class nikeHomePage {

    private WebDriver driver;

    public nikeHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Navigation to the home page
    public void navigateToHomePage() {
        driver.get("https://www.nike.com/");
    }

    // Choosing a Men's Category
    public void selectMenCategory() {
        driver.findElement(By.linkText("Men")).click(); //
    }
    // Function for clicking on the "Shoes" subcategory
    public void selectShoesCategory() {

        driver.findElement(By.linkText("Shoes")).click(); // Change to Text that matches the site
    }
    public void verifyNavBar(List expectedMenu){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> menuElements = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("menu-hover-trigger-link"))
        );

        // Creating an actual list from the website
        List<String> actualMenu = new ArrayList<>();
        for (WebElement element : menuElements) {
            System.out.println(element.getText());
            actualMenu.add(element.getText().trim()); // Add text to list
        }

        // Compare between the expected list and the actual list
        if (expectedMenu.equals(actualMenu)) {
            System.out.println("The menu matches the expected list.");
        } else {
            System.out.println("The menu does NOT match the expected list.");
            System.out.println("Expected: " + expectedMenu);
            System.out.println("Actual: " + actualMenu);
        }
    }


}
