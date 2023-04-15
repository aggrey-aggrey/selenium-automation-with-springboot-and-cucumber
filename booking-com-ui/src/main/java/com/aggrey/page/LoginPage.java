package com.aggrey.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {
    @FindBy(how = How.CSS, using = "input#username")
    WebElement userName;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    WebElement signInWithEmail;

    @Override
    public boolean isAt() {
        return  this.wait.until((driver) -> this.userName.isDisplayed());
    }

    public LoginPage login(String userName) {
        writeText(this.userName, userName);
      //  writeText(this.password, password);
        jsClick((By) signInWithEmail);
        return this;
    }


}
