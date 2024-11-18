package com.works.customValid;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ThyCityValid.class)
public @interface ThyCity {

    String message() default "Sadece Marmara bölgesi geçerli";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
