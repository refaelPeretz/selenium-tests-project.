package tests;

import base.BaseDriver;
import pages.HomePage;
import pages.ShoesPage;

public class NikeTestSize {
    public static void main(String[] args) throws InterruptedException {
        /* The next test
        will check whether the number of results displayed
        matches what was defined.
         */
        System.out.println("Start test");
        BaseDriver.setupDriver();
        HomePage homePage = new HomePage(BaseDriver.getDriver());

        homePage.navigateToHomePage();
        homePage.selectMenCategory();
        ShoesPage shoesPage = new ShoesPage(BaseDriver.getDriver());
        shoesPage.selectShoesCategory();
        shoesPage.selectWalkingCategory();
        System.out.println("Entered the Walking category.");
        int productCount = shoesPage.amountOfProducts();
        shoesPage.fallsTestAmount(productCount, 100);



        BaseDriver.closeDriver();





    }
}
