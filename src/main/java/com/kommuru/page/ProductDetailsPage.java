package com.kommuru.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * The class is used to capture product details page web elements and it's methods.
 *
 * @author Reddy
 */
public class ProductDetailsPage extends BasePage {
    @FindBy(xpath = "//p[@id='add_to_cart']/button")
    private WebElement addToCart;
    @FindBy(xpath = "//header[@id='header']/div[3]/div/div/div[3]/div")
    private WebElement cart;
    @FindBy(id = "button_order_cart")
    private WebElement proceedToCheckout;
    @FindBy(tagName = "h1")
    private WebElement pdp;
    @FindBy(xpath = "//div[@id='page']")
    private WebElement frame;
    @FindBy(xpath = "//div[@id='layer_cart']")
    private WebElement basketMessage;



    public ProductDetailsPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void addToCartButton() {
        driver.switchTo().activeElement();
        addToCart.click();
    }

    public Boolean isPDPPageDisplayed() {
        return pdp.isDisplayed();
    }

    public Boolean isItemAddedToBasket() {
        return basketMessage.isDisplayed();
    }

    public CartSummaryPage clickOnProceedToCheckoutBtn() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(proceedToCheckout));
        proceedToCheckout.click();
        return new CartSummaryPage();
    }
}
