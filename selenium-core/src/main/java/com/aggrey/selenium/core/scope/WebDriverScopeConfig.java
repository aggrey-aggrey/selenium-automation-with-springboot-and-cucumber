package com.aggrey.selenium.core.scope;


import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebDriverScopeConfig {
    /**
     * WebDriverScopeConfig a configuration class, and
     * it creates the WebdriverScopePostProcessor bean.
     *
     */
    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor(){
        return new WebDriverScopePostProcessor();
    }
}
