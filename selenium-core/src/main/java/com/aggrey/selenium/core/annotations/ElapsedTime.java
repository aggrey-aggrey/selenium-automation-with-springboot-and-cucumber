package com.aggrey.selenium.core.annotations;


import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)

public @interface ElapsedTime {
}
