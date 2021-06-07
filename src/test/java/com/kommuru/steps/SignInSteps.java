package com.kommuru.steps;

import com.kommuru.page.BasePage;
import com.kommuru.page.HomePage;
import com.kommuru.page.MyAccountPage;
import com.kommuru.page.SignInPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

/**
 * The class is used to define sign in step definitions.
 *
 * @author Reddy
 */
public class SignInSteps extends BasePage {

    private HomePage homePage;
    private MyAccountPage myAccountPage;
    private SignInPage signInPage;

    @Given("user is on automation practice homepage")
    public void userIsOnAutomationPracticeHomePage() {
        homePage = new HomePage();
        homePage.navigateHomePage();
    }

    @When("i click on sign in link")
    public void iClickOnSignInLink() {
        signInPage = homePage.clickOnSignInLink();
    }

    @Then("i should be in authentication page")
    public void iShouldBeInAuthenticationPage() {
        assertEquals("AUTHENTICATION", signInPage.getAuthenticationText());
    }

    @Then("i should be in my account page")
    public void iShouldBeInMyAccountPage() {
        assertEquals("MY ACCOUNT", myAccountPage.myAccountText());
    }


    @When("i click on sign out link")
    public void iClickOnSignOutLink() {
        signInPage = myAccountPage.clickOnSignout();
    }

    @When("i enter emailId (.*) and password (.*) and click on signin button")
    public void iEnterEmailIdAndPasswordAndClickOnSignInButton(String emailId, String password) {
        myAccountPage = signInPage.enterLoginDetails(emailId, password);
    }

    @When("i click on my personal information")
    public void iClickOnMyPersonalInformation() {
        myAccountPage.clickOnPersonalInfo();
    }

    @And("change firstName to (.*)")
    public void changeFirstNameTo(String updateName) {
        myAccountPage.enterFirstName(updateName);
    }

    @And("click on save button")
    public void clickOnSaveButton() {
        myAccountPage.saveButton();
    }
}
