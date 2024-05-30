package com.example.construction_company_management.validation.annotation;

import com.example.construction_company_management.exсeption.ErrorMessage;
import com.example.construction_company_management.validation.constraint.UuidFormatCheckerConstraint;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UuidFormatCheckerConstraint.class)

public @interface UuidFormatChecker {
    String message() default ErrorMessage.NotUuidFormat;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
