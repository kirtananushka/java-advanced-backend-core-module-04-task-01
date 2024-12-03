package com.tananushka.usersapp.dto;

import com.tananushka.usersapp.entity.Role;
import com.tananushka.usersapp.validation.ValidRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserRequest {
   @NotBlank(message = "Username is required")
   private String username;

   @Email(message = "Invalid email format")
   @NotBlank(message = "Email is required")
   private String email;

   @NotBlank(message = "Password is required")
   @Size(min = 6, message = "Password must be at least 6 characters")
   private String password;

   @NotNull(message = "Role is required")
   @ValidRole(message = "Invalid role. Allowed values are: ROLE_USER, ROLE_MODERATOR, ROLE_ADMIN")
   private Role role;
}
