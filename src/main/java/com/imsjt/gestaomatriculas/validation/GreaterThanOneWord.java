package com.imsjt.gestaomatriculas.validation;

import com.imsjt.gestaomatriculas.validation.annotation.GreaterThanOneWorldValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Repeatable(GreaterThanOneWord.List.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GreaterThanOneWorldValidation.class)
public @interface GreaterThanOneWord {

    String message() default "{error.business.greater_than_one_word}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.FIELD})
    @interface List {
        GreaterThanOneWord[] value();
    }

}
