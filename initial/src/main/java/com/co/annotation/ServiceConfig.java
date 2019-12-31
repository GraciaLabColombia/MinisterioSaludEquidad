package com.co.annotation;

import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ServiceConfig
{
    String protocol() default "http";
    String domain();
    String port();
    RequestMethod method() default RequestMethod.GET;
    String name();
    String clientId();
    String uri();
    String[] headers() default "";
    String[] params() default "";
}
