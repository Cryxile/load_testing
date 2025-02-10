package com.zuzex.education.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CharacterValidator implements ConstraintValidator<Char, Character> {
    private String regexp;

    @Override
    public void initialize(Char constraintAnnotation) {
        this.regexp = constraintAnnotation.regexp();
    }

    @Override
    public boolean isValid(Character character, ConstraintValidatorContext context) {
        return character != null && String.valueOf(character).matches(regexp);
    }
}
