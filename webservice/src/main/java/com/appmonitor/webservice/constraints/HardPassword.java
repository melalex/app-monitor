package com.appmonitor.webservice.constraints;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@NotNull
@Size(min = 6, max = 255)
@AtLeastOneLowerCaseLatter
@AtLeastOneUpperCaseLatter
@AtLeastOneSpecialCharacter
public @interface HardPassword {

}
