package com.example.construction_company_management.validation.constraint;

import com.example.construction_company_management.validation.annotation.UuidFormatChecker;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Optional;

/**
 * Validator class to check if a given string is a valid UUID format.
 */

public class UuidFormatCheckerConstraint implements ConstraintValidator<UuidFormatChecker, String> {
    private static final String UUID_PATTERN = "^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";

    @Override
    public void initialize(UuidFormatChecker constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }


    @Override
    public boolean isValid(String uuid, ConstraintValidatorContext context) {
        return Optional.ofNullable(uuid)
                .filter(el -> !el.isBlank())
                .map(el -> el.matches(UUID_PATTERN))
                .orElse(false);
    }
}
