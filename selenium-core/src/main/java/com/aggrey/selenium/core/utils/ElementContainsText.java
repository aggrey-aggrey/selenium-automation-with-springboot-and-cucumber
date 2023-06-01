package com.aggrey.selenium.core.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import javax.annotation.CheckForNull;
import java.util.Objects;

public class ElementContainsText implements ExpectedCondition<Boolean> {
    /**
     * This custom-expected condition class waits until the element contains a specific text.
     */
    private final String textToFind;
    private final By by;

    public ElementContainsText(final By by, final String textToFind ) {
        this.by = by;
        this.textToFind = textToFind;
    }


    //Override the apply method with your own functionality
    @Override
    public Boolean apply(WebDriver driver) {
        //Find the element with given By method(By CSS,XPath,Name, etc.)
        WebElement element = Objects
                .requireNonNull(driver)
                .findElement(this.by);

        //check that the element contains given text/
        return element
                .getText()
                .contains(this.textToFind);
    }

    @Override
    public boolean equals(@CheckForNull Object o) {
        return false;
    }

    //This is for log message. I override it because when test fails, it will give us a meaningful message.
    @Override
    public String toString() {
        return ": \"Does " + this.by + " contain " + this.textToFind + "?\"";
    }

}
