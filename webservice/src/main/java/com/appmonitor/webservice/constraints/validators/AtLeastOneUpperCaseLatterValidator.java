package com.appmonitor.webservice.constraints.validators;

import com.appmonitor.webservice.constraints.AtLeastOneUpperCaseLatter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class AtLeastOneUpperCaseLatterValidator implements ConstraintValidator<AtLeastOneUpperCaseLatter, String> {
    private static final String regExp = "(?=.*[0-9])";
    private static final Pattern pattern = Pattern.compile(regExp);

    @Override
    public void initialize(AtLeastOneUpperCaseLatter constraintAnnotation) {

    }

    @Override
    public boolean isValid(String obj, ConstraintValidatorContext context) {
        return pattern.matcher(obj).matches();
    }
}
