package com.aggrey.configuration;


import com.aggrey.annotations.LazyConfiguration;
import com.aggrey.annotations.WebDriverScopeBean;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;

import java.time.Duration;

@LazyConfiguration
public class WebDriverWaitConfig {

    @Value("${default.timeout:30}")
    private int timeout;

    public WebDriverWait webDriverWait(WebDriver driver){
        return new WebDriverWait(driver, Duration.ofMillis(this.timeout));
    }
}
