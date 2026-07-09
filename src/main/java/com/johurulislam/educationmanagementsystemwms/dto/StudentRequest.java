package com.johurulislam.educationmanagementsystemwms.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record StudentRequest(
        @NotBlank(message = "Student ID is required")
        String studentId,

        String fullName,

        @NotBlank(message = "Email is required")
        @Email(message = "Email must be valid")
        String email,

        @Pattern(regexp ="^\\+?[0-9\\s-]{7,15}$", message = "Phone number is invalid")
        String phone,

        String department,

        LocalDate admissionDate
) {}
