package tests;
import base.BaseDriver;
import org.openqa.selenium.WebDriver;
import pages.nikeHomePage;

import java.util.Arrays;
import java.util.List;

public class NikeNavBarTest {
    public static void main(String[] args) {
        /*The next test
         will check whether the menu matches
         a list of strings that I defined as a menu.
         */
        BaseDriver.setupDriver();
        WebDriver driver = BaseDriver.getDriver();

        // Navigating the Nike homepage.
        nikeHomePage homePage = new nikeHomePage(driver);
        homePage.navigateToHomePage();

        // Expected list of menu items
        List<String> expectedMenu = Arrays.asList("New & Featured", "Men", "Women", "Kids");
        homePage.verifyNavBar(expectedMenu);

        BaseDriver.closeDriver();
    }
}
