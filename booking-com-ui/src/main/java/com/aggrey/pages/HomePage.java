package com.aggrey.pages;


import com.aggrey.base.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class HomePage extends BasePage {
    @Autowired
    RegisterPage registerPage;
    @Autowired
    LoginPage loginPage;
    @Value("${application.url}")
    private String baseURL;
    @FindBy(how = How.CSS, using = "[data-testid='header-logo']")
    public WebElement  headerLogo;
    @FindBy(how = How.XPATH, using = "//a[@pathname='/auth/oauth2']/span[@innertext='Sign in']")
    public WebElement  signInBtn;
    @FindBy(how = How.CSS, using = "a[aria-label='Create an account'] span[class='e57ffa4eb5']")
    public WebElement registerBtn;

    public HomePage goToHomePage() {
        driver.get(baseURL);
        return this;
    }

    public RegisterPage clickRegisterBtn() {
        jsClick((By) registerBtn);
        return registerPage;
    }

    public LoginPage clickSignBtn() {
        jsClick((By) signInBtn);
        return loginPage;
    }

    @Override
    public boolean isAt() {
        return  this.wait.until((driver) -> this.signInBtn.isDisplayed());
    }

    public HomePage goToLoginPage() {
        click(signInBtn);
        return this;
    }
}
