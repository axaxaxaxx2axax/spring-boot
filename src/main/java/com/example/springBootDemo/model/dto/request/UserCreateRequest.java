package com.example.springBootDemo.model.dto.request;

public record UserCreateRequest(
        String username,
        String password
) {
}
