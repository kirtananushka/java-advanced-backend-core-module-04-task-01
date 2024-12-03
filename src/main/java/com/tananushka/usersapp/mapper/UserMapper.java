package com.tananushka.usersapp.mapper;

import com.tananushka.usersapp.dto.CreateUserRequest;
import com.tananushka.usersapp.dto.UserDto;
import com.tananushka.usersapp.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
   public UserDto toDto(UserEntity entity) {
      return UserDto.builder()
            .id(entity.getId())
            .username(entity.getUsername())
            .email(entity.getEmail())
            .role(entity.getRole())
            .createdAt(entity.getCreatedAt())
            .updatedAt(entity.getUpdatedAt())
            .build();
   }

   public UserEntity toEntity(CreateUserRequest request) {
      return UserEntity.builder()
            .username(request.getUsername())
            .email(request.getEmail())
            .password(request.getPassword())
            .role(request.getRole())
            .build();
   }
}