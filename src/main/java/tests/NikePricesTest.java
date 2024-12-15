package tests;

import base.BaseDriver;
import pages.nikeHomePage;
import pages.nikeShoesPage;

public class NikePricesTest {
    public static void main(String[] args) {
        /* The test will check
        whether the prices match
        what I defined as the maximum price or not.
         */
        BaseDriver.setupDriver();
        nikeHomePage homePage = new nikeHomePage(BaseDriver.getDriver());

        homePage.navigateToHomePage();
        homePage.selectMenCategory();

        nikeShoesPage shoesPage = new nikeShoesPage(BaseDriver.getDriver());
        shoesPage.selectShoesCategory();

        // Here I pass the option index (to 3 for "Price: Low-High")
        shoesPage.sortByPriceLowToHigh();
        shoesPage.checkPriceUnderLimit();

        BaseDriver.closeDriver();
    }

}
