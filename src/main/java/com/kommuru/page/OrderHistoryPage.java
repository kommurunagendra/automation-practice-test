package com.kommuru.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
/**
 * The class is used to capture order history page web elements and it's methods.
 *
 * @author Reddy
 */
public class OrderHistoryPage extends BasePage {
    @FindBy(tagName = "h1")
    private WebElement orderHistory;

    public OrderHistoryPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public String getPageName() {
        return orderHistory.getText();
    }
}
