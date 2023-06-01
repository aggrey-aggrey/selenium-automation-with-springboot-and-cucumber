package com.aggrey.selenium.core.scope;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.SimpleThreadScope;

import java.util.Objects;

public class WebDriverScope extends SimpleThreadScope {
    /**
     *
     * WebDriverScope extends the SimpleThreadScope based on the webdriver session and cleans the threadScope map.
     * It is a ThreadLocal map inside SimpleThreadScope class.
     */
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object o = super.get(name, objectFactory);
        SessionId sessionId = ((RemoteWebDriver)o).getSessionId();
        if(Objects.isNull(sessionId)){
            super.remove(name);
            o = super.get(name, objectFactory);
        }
        return o;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
    }
}
