package com.aggrey.configuration;


import com.aggrey.annotations.LazyConfiguration;
import com.aggrey.annotations.WebDriverScopeBean;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.time.Duration;

@LazyConfiguration
public class WebDriverWaitConfig {
    /** This class is for auto-wiring the WebdriverWait instance in the tests.
     *  The default timeout duration is set as 30 seconds, and for parallel test execution,
     *  the bean is annotated with @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE).
     *  A bean with the prototype scope will return a different instance every time it is requested from the container.
     */

    @Value("${default.timeout:30}")
    private int timeout;

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public WebDriverWait webDriverWait(WebDriver driver){
        return new WebDriverWait(driver, Duration.ofMillis(this.timeout));
    }
}
