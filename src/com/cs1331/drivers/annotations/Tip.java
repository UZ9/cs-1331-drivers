package com.cs1331.drivers.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Tip {
    /**
     * Used to display a helpful tip when the user fails a test.
     * 
     * @return The main tip body message
     */
    public String description() default "";
}
