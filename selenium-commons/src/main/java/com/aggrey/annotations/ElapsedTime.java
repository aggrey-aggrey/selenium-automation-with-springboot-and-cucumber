package com.aggrey.annotations;


import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)

public @interface ElapsedTime {
}
