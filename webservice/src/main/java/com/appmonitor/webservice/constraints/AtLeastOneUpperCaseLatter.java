package com.appmonitor.webservice.constraints;

import com.appmonitor.webservice.constraints.validators.AtLeastOneUpperCaseLatterValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AtLeastOneUpperCaseLatterValidator.class)
@Documented
public @interface AtLeastOneUpperCaseLatter {

    String message() default "{constraints.atLeastOneUpperCaseLatter}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
