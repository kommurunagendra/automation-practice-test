package com.kommuru.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
/**
 * The class is used to capture cart summary page web elements and it's methods.
 *
 * @author Reddy
 */
public class CartSummaryPage extends BasePage {
    @FindBy(css = "button btn btn-default standard-checkout button-medium")
    private WebElement proceedToCheckoutBtn;
    @FindBy(id = "cart_title")
    private WebElement title;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "passwd")
    private WebElement pwd;
    @FindBy(id = "SubmitLogin")
    private WebElement signInBtn;
    @FindBy(id = "uniform-cgv")
    private WebElement termsOfService;
    @FindBy(css = ".bankwire")
    private WebElement bankWire;
    @FindBy(xpath = "//div[@id='center_column']/form/p/button")
    private WebElement proceedToCheckout;
    @FindBy(xpath = "//div[@id='center_column']/p[2]/a[1]")
    private WebElement shippingProceedtoCheckout;
    @FindBy(xpath = "//form[@id='form']/p/button")
    private WebElement proceedToCheckoutNow;
    @FindBy(xpath = "//*[@id='cart_navigation']/button")
    private WebElement orderSummary;
    @FindBy(xpath = "//div[@id='center_column']/p/a")
    private WebElement backToOrders;
    @FindBy(tagName = "h1")
    private WebElement pageName;

    public CartSummaryPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void clickOnCheckoutBtn() {
        proceedToCheckoutBtn.click();
    }

    public String getText() {
        return title.getText();
    }

    public void signInButton() {
        signInBtn.click();
    }

    public void clickOnTermsOfService() {
        termsOfService.click();
    }

    public void clickOnBankWireOption() {
        bankWire.click();
    }

    public void clickOnProceedToCheckout() {
        proceedToCheckout.click();
    }

    public void clickOnProceedToCheckoutInShippingTab() {
        proceedToCheckoutNow.click();
    }

    public void clickOnProceedtoCheckoutSummary() {
        shippingProceedtoCheckout.click();
    }

    public void enterLoginDetails(String emailId, String password) {
        email.sendKeys(emailId);
        pwd.sendKeys(password);
        signInButton();
    }

    public void clickOnOrderSummary() {
        orderSummary.click();
    }

    public OrderHistoryPage clickOnBackToOrder() {
        backToOrders.click();
        return new OrderHistoryPage();
    }

    public String getPageName() {
        return pageName.getText();
    }
}
