package tests;

import base.BaseDriver;
import pages.nikeHomePage;
import pages.nikeShoesPage;

public class NikeSizeTest {
    public static void main(String[] args) throws InterruptedException {
        /* The test
        will check whether the number of results displayed
        matches what was defined.
         */
        BaseDriver.setupDriver();
        nikeHomePage homePage = new nikeHomePage(BaseDriver.getDriver());
        nikeShoesPage shoesPage = new nikeShoesPage(BaseDriver.getDriver());

        homePage.navigateToHomePage();
        homePage.selectMenCategory();
        shoesPage.selectShoesCategory();
        shoesPage.selectWalkingCategory();
        int productCount = shoesPage.amountOfProducts();
        shoesPage.verifyTestAmount(productCount, 100);

        BaseDriver.closeDriver();

    }
}
