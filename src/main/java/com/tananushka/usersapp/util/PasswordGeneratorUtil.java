package com.tananushka.usersapp.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGeneratorUtil {
   public static void main(String[] args) {
      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

      String[] passwords = {
            "password"
      };

      for (String password : passwords) {
         String hashedPassword = encoder.encode(password);
         System.out.printf("Original password: %-20s | Hashed: %s%n", password, hashedPassword);
      }
   }
}