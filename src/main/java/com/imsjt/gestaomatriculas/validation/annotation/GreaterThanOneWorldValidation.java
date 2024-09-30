package com.imsjt.gestaomatriculas.validation.annotation;

import com.imsjt.gestaomatriculas.validation.GreaterThanOneWord;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GreaterThanOneWorldValidation implements ConstraintValidator<GreaterThanOneWord, String> {

    @Override
    public boolean isValid(String field, ConstraintValidatorContext constraintValidatorContext) {
        return field.split(" ").length > 1;
    }

}
