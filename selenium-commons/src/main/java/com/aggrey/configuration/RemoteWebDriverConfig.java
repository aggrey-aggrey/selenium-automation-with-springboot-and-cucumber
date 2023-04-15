package com.aggrey.configuration;

import com.aggrey.annotations.LazyConfiguration;
import com.aggrey.annotations.WebDriverScopeBean;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import java.net.URL;


@Profile("grid")
@LazyConfiguration
public class RemoteWebDriverConfig {
    /**
     * @Profile(“grid”) annotation is for Selenium Grid and remotewebdriver.
     * When we run the tests with “spring.profiles.active=grid” environment variable,
     * the tests will use application-grid.properties file under the resources folder as the main configuration file.
     */

    @Value("${selenium.grid.url}")
    private URL url;

    @WebDriverScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    @Primary
    public WebDriver remoteFirefoxDriver(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        return new RemoteWebDriver(this.url, firefoxOptions);
    }

    @WebDriverScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "edge")
    @Primary
    public WebDriver remoteEdgeDriver(){
        EdgeOptions edgeOptions = new EdgeOptions();
        return new RemoteWebDriver(this.url, edgeOptions);
    }

    @WebDriverScopeBean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    @Primary
    public WebDriver remoteChromeDriver(){
        ChromeOptions chromeOptions = new ChromeOptions();
        return new RemoteWebDriver(this.url, chromeOptions);
    }
}
