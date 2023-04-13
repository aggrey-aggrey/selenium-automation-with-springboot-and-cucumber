package com.aggrey.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class BasePage {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected WebDriverWait wait;

    @Autowired
    protected JavascriptExecutor javascriptExecutor;

    //@Autowired
    //protected LogUtil logUtil;;

    private  void init(){
        PageFactory.initElements(this.driver, this);
    }

    public abstract boolean isAt();
    public<T> void waitForElement(T elementAttribute){
        if(elementAttribute
                .getClass()
                .getName()
                .contains("By")) {
            wait.until(ExpectedConditions.presenceOfElementLocated((By) elementAttribute));

        }else {
            wait.until(ExpectedConditions.visibilityOf((WebElement) elementAttribute));

        }
    }
    public <T> void waitElements(T elementAttribute) {
        if (elementAttribute
                .getClass()
                .getName()
                .contains("By")) {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By) elementAttribute));
        } else {
            wait.until(ExpectedConditions.visibilityOfAllElements((WebElement) elementAttribute));
        }
    }

    //Click Method by using JAVA Generics (You can use both By or Web element)
    public <T> void click(T elementAttribute) {
        waitForElement(elementAttribute);
        if (elementAttribute
                .getClass()
                .getName()
                .contains("By")) {
            driver
                    .findElement((By) elementAttribute)
                    .click();
        } else {
            ((WebElement) elementAttribute).click();
        }
    }



    public void jsClick(By by) {
        javascriptExecutor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(by)));
    }

    //Write Text by using JAVA Generics (You can use both By or WebElement)
    public <T> void writeText(T elementAttribute, String text) {
        waitForElement(elementAttribute);
        if (elementAttribute
                .getClass()
                .getName()
                .contains("By")) {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By) elementAttribute));
            driver
                    .findElement((By) elementAttribute)
                    .sendKeys(text);
        } else {
            wait.until(ExpectedConditions.visibilityOf((WebElement) elementAttribute));
            ((WebElement) elementAttribute).sendKeys(text);
        }
    }

    //Read Text by using JAVA Generics (You can use both By or WebElement)
    public <T> String readText(T elementAttribute) {
        if (elementAttribute
                .getClass()
                .getName()
                .contains("By")) {
            return driver
                    .findElement((By) elementAttribute)
                    .getText();
        } else {
            return ((WebElement) elementAttribute).getText();
        }
    }

 //   @SneakyThrows
    public <T> String readTextErrorMessage(T elementAttribute) throws InterruptedException {
        Thread.sleep(5000); //This needs to be improved.
        return driver
                .findElement((By) elementAttribute)
                .getText();
    }

    //Close popup if exists
    public void handlePopup(By by) throws InterruptedException {
        waitElements(by);
        List<WebElement> popup = driver.findElements(by);
        if (!popup.isEmpty()) {
            popup
                    .get(0)
                    .click();
            Thread.sleep(200);
        }
    }


}
