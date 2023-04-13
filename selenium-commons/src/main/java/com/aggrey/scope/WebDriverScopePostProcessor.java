package com.aggrey.scope;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class WebDriverScopePostProcessor  implements BeanFactoryPostProcessor {
     @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
         beanFactory.registerScope("webdriverscope", new WebDriverScope());
     }
}
