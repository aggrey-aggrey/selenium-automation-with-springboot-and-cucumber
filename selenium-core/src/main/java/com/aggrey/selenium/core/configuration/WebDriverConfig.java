package com.aggrey.selenium.core.configuration;


import com.aggrey.selenium.core.annotations.WebDriverScopeBean;
import com.aggrey.selenium.core.annotations.LazyConfiguration;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;


@Profile("!grid")
@LazyConfiguration
public class WebDriverConfig {

    /**
     *
     *@Profile(“!grid”) tells us that this configuration works when the profile is not the grid.
     *
     * @WebdriverScopeBean is for parallel test execution.
     *
     * @ConditionalOnProperty annotation helps us use the specific beans based on the properties in the configuration properties file
     * which is application.properties in the resource folder.
     *
     * @Primary annotation gives a higher preference to a bean when there are multiple beans of the same type.
     *
     * @ConditionalMissingBean annotation lets a bean be included based on the absence of specific beans.
     **/
    @WebDriverScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver firefoxDriver(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        Proxy proxy = new Proxy();
        proxy.setAutodetect(false);
        proxy.setNoProxy("no_proxy-var");
        firefoxOptions.setCapability("proxy", proxy);
        return new FirefoxDriver(firefoxOptions);

    }

    @WebDriverScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "edge")
    @Primary
    public WebDriver edgeDriver() {
        return new EdgeDriver();
    }

    @WebDriverScopeBean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    @Primary
    public WebDriver chromeDriver() {
        return new ChromeDriver();
    }
}
