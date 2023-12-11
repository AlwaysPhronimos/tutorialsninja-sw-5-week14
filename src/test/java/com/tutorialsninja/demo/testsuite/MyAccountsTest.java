package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.MyAccountLoginPage;
import com.tutorialsninja.demo.pages.MyAccountPage;
import com.tutorialsninja.demo.pages.MyAccountRegisterPage;
import com.tutorialsninja.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountsTest extends TestBase {
    MyAccountPage myAccountPage;
    MyAccountRegisterPage accountRegisterPage;
    MyAccountLoginPage accountLoginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        myAccountPage = new MyAccountPage();
        accountRegisterPage = new MyAccountRegisterPage();
        accountLoginPage = new MyAccountLoginPage();
    }

    @Test(groups = {"sanity","smoke", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        //1.1 Click on My Account Link.
        myAccountPage.clickOnMyAccountTab();
        // 1.2 Call the method “selectMyAccountOptions” method and pass the parameter Register
        myAccountPage.selectMyAccountOptions("Register");
        //1.3 Verify the text “Register Account”
        Assert.assertEquals(myAccountPage.getRegisterAccountText(), "Register Account", "Register Account not displayed");
    }

    @Test(groups = {"smoke","regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Click on My Account Link.
        myAccountPage.clickOnMyAccountTab();
        // 2.2 Call the method “selectMyAccountOptions” method and pass the parameter "Login"
        myAccountPage.selectMyAccountOptions("Login");
        //2.3 Verify the text “Returning Customer”
        Assert.assertEquals(myAccountPage.getReturningCustomerText(), "Returning Customer", "Returning Customer Text not displayed");
    }

    @Test(groups = {"regression"})
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        //3.1 Click on My Account Link.
        myAccountPage.clickOnMyAccountTab();
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter Register
        myAccountPage.selectMyAccountOptions("Register");
        //3.3 Enter First Name
        accountRegisterPage.enterFirstName();
        //3.4 Enter Last Name
        accountRegisterPage.enterLastName();
        //3.5 Enter Email
        accountRegisterPage.enterEmail();
        //3.6 Enter Telephone
        accountRegisterPage.enterTelephone();
        //3.7 Enter Password
        accountRegisterPage.enterPassword();
        //3.8 Enter Password Confirm
        accountRegisterPage.enterConfirmPassword();
        //3.9 Select Subscribe Yes radio button
        accountRegisterPage.selectSubscribeYesRadioButton();
        //3.10 Click on Privacy Policy check box
        accountRegisterPage.clickPrivacyPolicyCheckbox();
        //3.11 Click on Continue button
        accountRegisterPage.clickOnContinueButton();
        //3.12 Verify the message “Your Account Has Been Created!”
        Assert.assertEquals(accountRegisterPage.getAccountHasBeenCreatedText(), "Your Account Has Been Created!", "Cannot create account");
        // 3.13 Click on Continue button
        accountRegisterPage.clickOnContinueButtonAgain();
        //3.14 Click on My Account Link.
        accountRegisterPage.clickOnMyAccountLink();
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter "Logout"
        myAccountPage.selectMyAccountOptions("Logout");
        //3.16 Verify the text “Account Logout”
        Assert.assertEquals(accountRegisterPage.getAccountLogoutText(), "Account Logout", "Cannot logout");
        //3.17 Click on Continue button
        accountRegisterPage.clickOnContinueButton3();
    }
    @Test(groups = {"regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //4.1 Click on My Account Link
        myAccountPage.clickOnMyAccountTab();
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter "login"
        myAccountPage.selectMyAccountOptions("Login");
        //4.3 Enter Email address
        accountLoginPage.enterEmailAddress();
        //4.5 Enter Password
        accountLoginPage.enterValidPassword();
        //4.6 Click on Login button
        accountLoginPage.clickOnLoginButton();
        //4.7 Verify text “My Account”
        Assert.assertEquals(accountLoginPage.getMyAccountText(), "My Account", "Error Message");
        //4.8 Click on My Account Link.
        myAccountPage.clickOnMyAccount1();
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter "Logout"
        myAccountPage.selectMyAccountOptions("Logout");
        // 4.10 Verify the text “Account Logout”
        Assert.assertEquals(accountRegisterPage.getAccountLogoutText(), "Account Logout", "Cannot logout");
        //4.11 Click on Continue button
        accountRegisterPage.clickOnContinueButtonAgain();
    }

}
