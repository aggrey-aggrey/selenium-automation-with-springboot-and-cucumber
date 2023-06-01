package com.aggrey.booking.ui.steps;

import com.aggrey.selenium.core.annotations.ElapsedTime;
import com.aggrey.selenium.core.annotations.LazyAutowired;
import com.aggrey.selenium.core.annotations.LazyComponent;
import com.aggrey.selenium.core.annotations.TakeScreenShot;
import com.aggrey.selenium.core.base.BasePage;
import com.aggrey.booking.ui.pages.HomePage;
import com.aggrey.booking.ui.pages.LoginPage;
import org.springframework.beans.factory.annotation.Value;

@LazyComponent
public class LoginSteps {
    /**
     * auto-wired the page classes and defined the scenario methods.
     * The @ElapsedTime and @TakeScreenshot annotations are Spring AOP (aspect-oriented programming)
     * we are readomg the browser value from the configuration properties by using @Value annotation of the spring framework.
     */
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
