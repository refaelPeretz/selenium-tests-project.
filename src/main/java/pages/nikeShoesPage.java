package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Thread.sleep;

public class nikeShoesPage {

    private WebDriver driver;

    public nikeShoesPage(WebDriver driver) {
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

    public boolean isFirstProductPriceAbove100() {
        WebElement firstProductPriceElement = driver.findElement(By.className("product-price"));
        String firstProductPriceText = firstProductPriceElement.getText();
        System.out.println("First product price text: " + firstProductPriceText); // הדפסה לבדיקה
        double firstProductPrice = Double.parseDouble(firstProductPriceText.replaceAll("[^\\d.]", ""));
        return firstProductPrice > 100;
    }
    public void debugProductPrices() {
        List<WebElement> prices = driver.findElements(By.className("product-price"));
        System.out.println("Number of price elements found: " + prices.size());
        for (WebElement price : prices) {
            System.out.println("Product price text: " + price.getText());
        }
    }
    public void selectWalkingCategory() throws InterruptedException {
//        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(15));
//        WebElement walkingCategory = wait2.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Walking"))));
        sleep(5000);
        WebElement walkingCategory = driver.findElement(By.cssSelector("[data-ndx='9']"));

        walkingCategory.click();
    }

    public int amountOfProducts(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".product-card__hero-image css-1fxh5tw")));

// Find and count all the products
        List<WebElement> products = driver.findElements(By.cssSelector("div.product-card[data-testid='product-card']"));
        int productCount = products.size();
        System.out.println("Number of products in the 'Walking' category: " + productCount);
        return productCount;
    }
    public void verifyTestAmount(int size, int min){
        if (size < min){
            System.out.println("The amount is less than the minimum required");
        }
        else {
            System.out.println("The amount is ok with the minimum required");

        }
    }

    public boolean isPricesSortedLowToHigh(int count) {

        //product-price__wrapper css-9xqpgk
        List<WebElement> pricesElements = driver.findElements(By.className("product-price__wrapper")); //product-card__price
        List<Double> prices = new ArrayList<>();
        for (WebElement i: pricesElements){
            System.out.println(i.getText());
        }
        System.out.println(pricesElements);


        // Text output and conversion to numbers
        for (int i = 0; i < Math.min(count, pricesElements.size()); i++) {
            String priceText = pricesElements.get(i).getText();
            double price = extractPrice(priceText); // שימוש בפונקציה לחילוץ המחיר
            prices.add(price);
        }

        // Create a copy of the list and check the sorting
        List<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);

        // Return if the list is the same
        return prices.equals(sortedPrices);
    }

    // Function to extract price from text
    private double extractPrice(String priceText) {
        // Remove any character that is not a digit or period.
        String numericPrice = priceText.replaceAll("[^\\d.]", "");
        return Double.parseDouble(numericPrice);
    }

    public void checkPriceUnderLimit(){
        List<String> products = getTopProducts(3);
        System.out.println("Here are the top products: ");
        for (String product : products) {
            System.out.println(product);
        }

        if (isFirstProductPriceAbove100()) {
            System.out.println("Test failed: The price of the first product is above 100 ILS");
        } else {
            System.out.println("The price of the first product is below 100 ILS");
        }
    }





}
