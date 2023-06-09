package com.tutorialsninja.testsuite;

import com.tutorialsninja.customListeners.CustomListeners;
import com.tutorialsninja.pages.AccountLoginPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.MyAccountPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


@Listeners(CustomListeners.class)
public class AccountLoginPageTest extends BaseTest {
    HomePage homePage;
    AccountLoginPage accountLoginPage;
    MyAccountPage accountPage;
    SoftAssert softAssert;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        accountLoginPage = new AccountLoginPage();
        accountPage = new MyAccountPage();
        softAssert = new SoftAssert();
    }
    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        homePage.clickOnMyAccountTab();
        homePage.selectMyAccountOptions("Login");
        softAssert(accountLoginPage.getReturningCustomerText(),
                "Returning Customer", "Login page not displayed");
        softAssert.assertAll();
    }

    @Test(groups = {"smoke","regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        homePage.clickOnMyAccountTab();
        homePage.selectMyAccountOptions("Login");
        accountLoginPage.enterEmailAddress("prime1233@gmail.com");
        accountLoginPage.enterPassword("test1234");
        accountLoginPage.clickOnLoginButton();
        Thread.sleep(2000);
        homePage.clickOnMyAccountTab();
        homePage.selectMyAccountOptions("Logout");
        softAssert(accountPage.getAccountLogoutText(), "Account Logout", "Not logged out");
        softAssert.assertAll();
    }
}

