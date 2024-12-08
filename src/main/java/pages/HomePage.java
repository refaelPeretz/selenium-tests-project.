package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // ניווט לעמוד הבית
    public void navigateToHomePage() {
        driver.get("https://www.nike.com/");
    }

    // בחירת קטגוריית גברים
    public void selectMenCategory() {
        driver.findElement(By.linkText("Men")).click(); // חיפוש לפי טקסט הלינק
    }
    // פונקציה ללחיצה על תת-הקטגוריה "נעליים"
    public void selectShoesCategory() {
        driver.findElement(By.linkText("Shoes")).click(); // שינוי ל-Text התואם באתר
    }


}
