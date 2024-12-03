package com.tananushka.usersapp.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class ErrorResponse {
   private int status;
   private String message;
   private List<String> errors;

   public ErrorResponse(int status, String message) {
      this.status = status;
      this.message = message;
      this.errors = new ArrayList<>();
   }
}