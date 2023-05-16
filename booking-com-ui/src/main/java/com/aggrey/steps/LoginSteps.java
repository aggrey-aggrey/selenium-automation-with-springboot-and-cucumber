package com.aggrey.steps;

import com.aggrey.annotations.ElapsedTime;
import com.aggrey.annotations.LazyAutowired;
import com.aggrey.annotations.LazyComponent;
import com.aggrey.annotations.TakeScreenShot;
import com.aggrey.pages.HomePage;
import com.aggrey.pages.LoginPage;
import org.springframework.beans.factory.annotation.Value;

@LazyComponent
public class LoginSteps {
    @Value("${browser}")
    private String browser;

    @LazyAutowired
    HomePage homePage;

    @LazyAutowired
    LoginPage loginPage;

    public LoginSteps givenIAmAtLoginPage() {
        homePage
                .goToHomePage()
                .goToLoginPage();

        return this;
    }

    @ElapsedTime
    public LoginSteps whenILogin(String userName, String password){
        loginPage
                .login(userName, password);
        return this;
    }


    @TakeScreenShot
    public LoginSteps thenIVerifyInvalidLoginMessage() throws InterruptedException {
        if(!browser.equalsIgnoreCase("firefox")) {
            loginPage
                .verifyLogEntryFailMessage();
        } else {
            loginPage.verifyPasswordErrorMessageWithCss("E-posta adresiniz veya şifreniz hatalı");
        }
        return this;
    }
    @TakeScreenShot
    public LoginSteps thenIVerifyPasswordErrorMessage(String expected) {
        loginPage
            .verifyPasswordErrorMessage(expected);
        return this;
    }
    @TakeScreenShot
    public LoginSteps thenIVerifyPasswordErrorMessageWithCss(String expected) throws InterruptedException {
        loginPage
            .verifyPasswordErrorMessageWithCss(expected);
        return this;
    }

    public LoginSteps thenIVerifyUserNameErrorMessages(String s) {
        loginPage
                .verifyLoginUserNameErrorMessage(s);
        return  this;
    }
}
