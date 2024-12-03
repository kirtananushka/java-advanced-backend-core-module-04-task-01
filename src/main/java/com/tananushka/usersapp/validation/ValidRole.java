package com.tananushka.usersapp.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidRoleValidator.class)
public @interface ValidRole {
   String message() default "Invalid role selection";

   Class<?>[] groups() default {};

   Class<? extends Payload>[] payload() default {};
}