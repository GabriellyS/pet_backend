package com.sherlockin.petbackend.auth.controller;

public record RegisterUserRecord(
    String email,
    String document,
    String firstName,
    String lastName,
    String password,
    String phone,
    String address
) {}
