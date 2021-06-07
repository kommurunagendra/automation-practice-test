package com.kommuru.steps;

import com.kommuru.page.*;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

/**
 * The class is used to define order details step definitions.
 *
 * @author Reddy
 */

public class OrderDetailsSteps extends BasePage {
    private HomePage homePage;
    private MyAccountPage myAccountPage;
    private SignInPage signInPage;
    private ProductListingPage productListingPage;
    private ProductDetailsPage productDetailsPage;
    private CartSummaryPage cartSummaryPage;
    private OrderHistoryPage orderHistoryPage;

    @Before
    public void setup() {
        BasePage.initializeBrowser();
    }

    @After
    public void tearDown() {
        BasePage.close();
    }

    @Given("user is on automation practice home page")
    public void userIsOnAutomationPracticeHomePage() {
        homePage = new HomePage();
        homePage.navigateHomePage();
    }

    @When("i select t-shirts category")
    public void iSelectTShirtsCategory() {
        productListingPage = homePage.clickOnTShirt();

    }

    @Then("i should be in t-shirts landing page")
    public void iShouldBeInTShirtsLandingPage() {
        System.out.println("productListingPage.getText();" + productListingPage.getText());
    }

    @When("i select t-shirt")
    public void iSelectTShirt() {
        productDetailsPage = productListingPage.selectProduct();
    }

    @Then("i should be in product details page")
    public void iShouldBeInProductDetailsPage() {
        System.out.println("isDisplayed: " + productDetailsPage.isPDPPageDisplayed());
    }

    @When("i click on add to cart button")
    public void iClickOnAddToCartButton() {
        productDetailsPage.addToCartButton();
    }

    @Then("t-shirt should be added into basket")
    public void tShirtShouldBeAddedIntoBasket() {
        System.out.println("isItemAddedtoBasket: " + productDetailsPage.isItemAddedToBasket());
    }

    @When("i click on proceed to checkout button")
    public void iClickOnProceedToCheckoutButton() {
        cartSummaryPage = productDetailsPage.clickOnProceedToCheckoutBtn();
    }


    @When("i enter emailId (.*) and password (.*) and click on sign in button")
    public void iEnterEmailIdAndPasswordAndClickOnSignInButton(String emailId, String password) {
        cartSummaryPage.enterLoginDetails(emailId, password);
    }

    @When("i click on terms of service")
    public void iClickOnTermsOfService() {
        cartSummaryPage.clickOnTermsOfService();
    }

    @When("i click on pay by bank wire option")
    public void iClickOnPayByBankWireOption() {
        cartSummaryPage.clickOnBankWireOption();
    }

    @Then("i should in order confirmation page")
    public void iShouldInOrderConfirmationPage() {
        assertEquals("ORDER CONFIRMATION", cartSummaryPage.getPageName());
    }


    @Then("i should be in order history details page")
    public void iShouldBeInOrderHistoryDetailsPage() {
        assertEquals("ORDER HISTORY", orderHistoryPage.getPageName());
    }

    @When("i click on proceed to checkout button in summary tab")
    public void iClickOnProceedToCheckoutButtonInSummaryTab() {
        cartSummaryPage.clickOnProceedtoCheckoutSummary();

    }

    @When("i click on proceed to checkout button in address tab")
    public void iClickOnProceedToCheckoutButtonInAddressTab() {
        cartSummaryPage.clickOnProceedToCheckout();
    }


    @And("i click on proceed to checkout button in terms of service tab")
    public void iClickOnProceedToCheckoutButtonInTermsOfServiceTab() {
        cartSummaryPage.clickOnProceedToCheckoutInShippingTab();

    }

    @When("i click on i confirm my order button in order summary tab")
    public void iClickOnIConfirmMyOrderButtonInOrderSummaryTab() {
        cartSummaryPage.clickOnOrderSummary();
    }

    @When("i click on back to order")
    public void iClickOnBackToOrder() {
        orderHistoryPage = cartSummaryPage.clickOnBackToOrder();
    }
}
