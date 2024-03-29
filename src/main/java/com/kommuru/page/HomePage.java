package com.kommuru.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * The class is used to capture home page web elements and it's methods.
 *
 * @author Reddy
 */
public class HomePage extends BasePage {

    @FindBy(css = ".login")
    private WebElement login;
    @FindBy(xpath = "//div[@id=\"block_top_menu\"]/ul/li[3]/a")
    private WebElement tshirt;

    public HomePage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void navigateHomePage() {
        driver.get(props.getProperty("baseUrl"));
    }

    public ProductListingPage clickOnTShirt() {
        tshirt.click();
        return new ProductListingPage();
    }

    public SignInPage clickOnSignInLink() {
        login.click();
        return new SignInPage();
    }
}
