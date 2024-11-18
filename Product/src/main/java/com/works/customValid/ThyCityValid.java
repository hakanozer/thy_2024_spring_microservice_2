package com.works.customValid;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class ThyCityValid implements ConstraintValidator<ThyCity, String> {

    String[] cities = {"İstanbul", "Bursa", "Tekirdağ", "Kocaeli"};

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Arrays.asList(cities).contains(value);
    }

}
