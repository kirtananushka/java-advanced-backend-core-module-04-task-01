package com.tananushka.usersapp.controller;

import com.tananushka.usersapp.dto.UserDto;
import com.tananushka.usersapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/users")
@RequiredArgsConstructor
public class UserControllerV2 {
   private final UserService userService;

   @GetMapping
   public ResponseEntity<Page<UserDto>> getUsers(Pageable pageable) {
      return ResponseEntity.ok(userService.getUsers(pageable));
   }
}