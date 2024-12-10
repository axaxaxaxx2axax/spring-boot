package com.example.springBootDemo.service;

import com.example.springBootDemo.exception.EntityNotFoundException;
import com.example.springBootDemo.model.User;
import com.example.springBootDemo.model.dto.request.UserCreateRequest;
import com.example.springBootDemo.repository.RoleRepository;
import com.example.springBootDemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public String createUser(UserCreateRequest request) {
        if (userRepository.existsByUserName(request.username())) {
            return "User already exists";
        }
        User user = User.builder()
                .userName(request.username())
                .password(passwordEncoder.encode(request.password()))
                .enabled(Boolean.TRUE)
                .build();
        roleRepository.findByName("ROLE_USER")
                        .ifPresent(user::addRole);
        userRepository.save(user);
        return "User created";
    }

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName)
                .orElseThrow(() -> new EntityNotFoundException("User " + userName + " not found"));
    }
}
