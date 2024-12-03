package com.tananushka.usersapp.validation;

import com.tananushka.usersapp.entity.Role;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class ValidRoleValidator implements ConstraintValidator<ValidRole, Role> {
   @Override
   public boolean isValid(Role role, ConstraintValidatorContext context) {
      if (role == null) {
         return false;
      }
      return Arrays.asList(Role.values()).contains(role);
   }
}