package com.appmonitor.webservice.constraints;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@File(types = "^image")
public @interface Image {
}
