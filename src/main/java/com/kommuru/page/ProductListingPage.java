package com.kommuru.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
/**
 * The class is used to capture product listing page web elements and it's methods.
 *
 * @author Reddy
 */
public class ProductListingPage extends BasePage {

    @FindBy(xpath = "//div[@id='special_block_right']/div/ul/li/a/img")
    private WebElement product;

    @FindBy(css = "button ajax_add_to_cart_button btn btn-default")
    private WebElement clickOnProduct;

    @FindBy(tagName = "h1")
    private WebElement title;

    public String getText() {
        return title.getText();
    }

    public ProductListingPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public ProductDetailsPage selectProduct() {
        product.click();;
        return new ProductDetailsPage();
    }


}
