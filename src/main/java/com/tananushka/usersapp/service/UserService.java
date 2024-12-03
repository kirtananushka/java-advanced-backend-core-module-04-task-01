package com.tananushka.usersapp.service;

import com.tananushka.usersapp.dto.CreateUserRequest;
import com.tananushka.usersapp.dto.UserDto;
import com.tananushka.usersapp.entity.UserEntity;
import com.tananushka.usersapp.exception.EmailAlreadyExistsException;
import com.tananushka.usersapp.exception.UserNotFoundException;
import com.tananushka.usersapp.exception.UsernameAlreadyExistsException;
import com.tananushka.usersapp.mapper.UserMapper;
import com.tananushka.usersapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
   private final UserRepository userRepository;
   private final UserMapper userMapper;
   private final PasswordEncoder passwordEncoder;

   public UserDto createUser(CreateUserRequest request) {
      if (userRepository.existsByUsername(request.getUsername())) {
         throw new UsernameAlreadyExistsException("Username already exists");
      }
      if (userRepository.existsByEmail(request.getEmail())) {
         throw new EmailAlreadyExistsException("Email already exists");
      }

      UserEntity user = userMapper.toEntity(request);
      user.setPassword(passwordEncoder.encode(request.getPassword()));
      return userMapper.toDto(userRepository.save(user));
   }

   public Page<UserDto> getUsers(Pageable pageable) {
      return userRepository.findAll(pageable)
            .map(userMapper::toDto);
   }

   public List<UserDto> getUsers() {
      return userRepository.findAll().stream()
            .map(userMapper::toDto)
            .toList();
   }

   public UserDto getUserById(Long id) {
      return userRepository.findById(id)
            .map(userMapper::toDto)
            .orElseThrow(() -> new UserNotFoundException("User not found"));
   }

   public UserDto updateUser(Long id, CreateUserRequest request) {
      UserEntity user = userRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException("User not found"));

      user.setUsername(request.getUsername());
      user.setEmail(request.getEmail());
      if (request.getPassword() != null) {
         user.setPassword(passwordEncoder.encode(request.getPassword()));
      }
      user.setRole(request.getRole());

      return userMapper.toDto(userRepository.save(user));
   }

   public void deleteUser(Long id) {
      if (!userRepository.existsById(id)) {
         throw new UserNotFoundException("User not found");
      }
      userRepository.deleteById(id);
   }
}