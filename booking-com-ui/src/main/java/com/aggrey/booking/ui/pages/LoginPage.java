package com.aggrey.booking.ui.pages;

import com.aggrey.selenium.core.base.BasePage;
import com.aggrey.selenium.core.annotations.LazyComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static org.junit.jupiter.api.Assertions.assertEquals;
@LazyComponent
public class LoginPage extends BasePage {

    @FindBy(how = How.CSS, using = "input#username")
    WebElement userName;
    @FindBy(how = How.CSS, using = "input[name='password']")
    WebElement password;
    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    WebElement signInWithEmail;


    //********* Web Elements by using By Class *********
    By loginButtonBy          = By.id("loginButton");
    By errorMessageUsernameBy = By.xpath("//*[@id=\"loginForm\"]/div[1]/div/div");
    By errorMessagePasswordBy = By.xpath("//*[@id=\"loginForm\"]/div[2]/div/div");
    By errorMessagePasswordCssBy = By.cssSelector("div[data-errormessagefor='password'] > .errorText");
    public LoginPage login(String userName, String password) {
        writeText(this.userName, userName);
       writeText(this.password, password);
        jsClick((By) signInWithEmail);
        return this;
    }

    public LoginPage verifyLoginUserNameErrorMessage(String expectedText) {

        assertEquals(expectedText, readText(errorMessageUsernameBy));
        return this;
    }
    public LoginPage verifyPasswordErrorMessage(String expectedText) {
        assertEquals(expectedText, readText(errorMessagePasswordBy));
        return this;
    }
    public LoginPage verifyPasswordErrorMessageWithCss(String expectedText) throws InterruptedException {
        assertEquals(expectedText, readTextErrorMessage(errorMessagePasswordCssBy));
        return this;
    }
    public LoginPage verifyLogEntryFailMessage() {
        logUtil.isLoginErrorLog(driver);
        return this;
    }
    @Override
    public boolean isAt() {
        return  this.wait.until((driver) -> this.userName.isDisplayed());
    }

}
