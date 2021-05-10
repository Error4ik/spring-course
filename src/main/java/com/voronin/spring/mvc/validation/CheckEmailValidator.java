package com.voronin.spring.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckEmailValidator implements ConstraintValidator<CheckEmail, String> {

    private String endOffEmail;

    @Override
    public void initialize(CheckEmail checkEmail) {
        this.endOffEmail = checkEmail.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return value.endsWith(this.endOffEmail);
    }
}
