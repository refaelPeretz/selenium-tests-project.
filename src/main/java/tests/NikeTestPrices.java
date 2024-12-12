package tests;

import base.BaseDriver;
import pages.HomePage;
import pages.ShoesPage;
import java.util.List;

public class NikeTestPrices {
    public static void main(String[] args) {
        /* The next test
         will check whether the prices match
         what I defined as the maximum price or not.
         */
        System.out.println("test start");
        BaseDriver.setupDriver();
        HomePage homePage = new HomePage(BaseDriver.getDriver());

        homePage.navigateToHomePage();
        System.out.println("enter nike");

        homePage.selectMenCategory();
        System.out.println("enter mens category");

        ShoesPage shoesPage = new ShoesPage(BaseDriver.getDriver());
        shoesPage.selectShoesCategory();
        System.out.println("enter shoes category");

        // Here I pass the option index (to 3 for "Price: Low-High")
        shoesPage.sortByPriceLowToHigh();
        System.out.println("Sort by price from low to high selected");

        List<String> products = shoesPage.getTopProducts(3);
        System.out.println("Here are the top products: ");
        for (String product : products) {
            System.out.println(product);
        }

        if (shoesPage.isFirstProductPriceAbove100()) {
            System.out.println("Test failed: The price of the first product is above 100 ILS");
            System.exit(1); // Test fail
        } else {
            System.out.println("The price of the first product is below 100 ILS");
        }
        shoesPage.debugProductPrices();



        BaseDriver.closeDriver();
        System.out.println("End test");
    }


}
