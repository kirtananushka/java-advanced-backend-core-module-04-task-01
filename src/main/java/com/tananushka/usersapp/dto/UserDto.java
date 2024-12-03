package com.tananushka.usersapp.dto;

import com.tananushka.usersapp.entity.Role;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserDto {
   private Long id;
   private String username;
   private String email;
   private Role role;
   private LocalDateTime createdAt;
   private LocalDateTime updatedAt;
}