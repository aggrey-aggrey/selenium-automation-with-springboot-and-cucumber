package com.aggrey.scope;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class WebDriverScopePostProcessor  implements BeanFactoryPostProcessor {
    /**
     * This class implements the BeanFactoryPostProcessor functional interface
     * and registers the scope as “webdriverscope” by using WebDriverScope class as an argument.
     */
     @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
         beanFactory.registerScope("webdriverscope", new WebDriverScope());
     }
}
