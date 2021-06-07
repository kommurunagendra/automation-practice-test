package com.kommuru.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The class is used to capture my account page web elements and it's methods.
 *
 * @author Reddy
 */
public class MyAccountPage extends BasePage {

    @FindBy(css = ".page-heading")
    private WebElement myAccount;
    @FindBy(xpath = "//div[@id='center_column']/div/div[1]/ul/li[4]/a")
    private WebElement myPersonalInfo;
    @FindBy(css = ".logout")
    private WebElement logout;
    @FindBy(id = "firstname")
    private WebElement firstName;
    @FindBy(xpath = "//div[@id='center_column']/div/form/fieldset/div[11]/button")
    private WebElement saveBtn;
    @FindBy(id = "old_passwd")
    private WebElement oldPassword;
    @FindBy(id = "passwd")
    private WebElement password;
    @FindBy(id = "confirmation")
    private WebElement confirmPassword;

    public MyAccountPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public String myAccountText() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(myAccount));
        return myAccount.getText();
    }

    public SignInPage clickOnSignout() {
        logout.click();
        return new SignInPage();
    }

    public void clickOnPersonalInfo() {
        myPersonalInfo.click();
    }

    public void enterFirstName(String name) {
        firstName.clear();
        firstName.sendKeys(name);
        oldPassword.sendKeys("Test@1234");
        password.sendKeys("Test@1234");
        confirmPassword.sendKeys("Test@1234");
    }

    public void saveButton() {
        saveBtn.click();
    }
}
