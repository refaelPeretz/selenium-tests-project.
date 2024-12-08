package tests;

import base.BaseDriver;
import pages.HomePage;
import pages.ShoesPage;
import java.util.List;

public class NikeTest {
    public static void main(String[] args) {
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

        BaseDriver.closeDriver();
        System.out.println("End test");
    }
}
