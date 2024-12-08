package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ShoesPage {

    private WebDriver driver;

    public ShoesPage(WebDriver driver) {
        this.driver = driver;
    }
    public void selectShoesCategory() {
        // Wait for click
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement shoesCategory = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Shoes")));
        shoesCategory.click();
    }


    public void sortByPriceLowToHigh() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click on Sort By dropdown
        WebElement sortButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@aria-label, 'Sort')]")));
        sortButton.click();

        // Wait and click on "Price: Low-High" option
        WebElement lowToHighOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Price: Low-High']")
        ));
        lowToHighOption.click();
    }




    public List<String> getTopProducts(int count) {
        List<String> products = new ArrayList<>();
        List<WebElement> titles = driver.findElements(By.className("product-card__title")); // מחלקה עבור כותרות
        List<WebElement> prices = driver.findElements(By.className("product-price")); // מחלקה עבור מחירים

        for (int i = 0; i < Math.min(count, titles.size()); i++) {
            String title = titles.get(i).getText();
            String price = prices.get(i).getText();
            products.add(title + " - " + price);
        }
        return products;
    }
}
