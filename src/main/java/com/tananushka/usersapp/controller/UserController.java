package com.tananushka.usersapp.controller;

import com.tananushka.usersapp.dto.CreateUserRequest;
import com.tananushka.usersapp.dto.UserDto;
import com.tananushka.usersapp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
   private final UserService userService;

   @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
   public ResponseEntity<UserDto> createUser(@Valid @RequestBody CreateUserRequest request) {
      return new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);
   }

   @GetMapping
   public ResponseEntity<List<UserDto>> getUsers() {
      return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
   }

   @GetMapping("/{id}")
   public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
      return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
   }

   @PutMapping("/{id}")
   public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @Valid @RequestBody CreateUserRequest request) {
      return new ResponseEntity<>(userService.updateUser(id, request), HttpStatus.OK);
   }

   @DeleteMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
      userService.deleteUser(id);
      return ResponseEntity.noContent().build();
   }
}