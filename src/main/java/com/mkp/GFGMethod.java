package com.mkp;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface GFGMethod {
    String date();

    String algo();

    String url() default "";

    Class[] impls() default {};

    String tComp() default "";

    String sComp() default "";
}
