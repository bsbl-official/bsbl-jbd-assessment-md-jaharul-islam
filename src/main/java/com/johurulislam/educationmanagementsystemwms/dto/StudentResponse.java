package com.johurulislam.educationmanagementsystemwms.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record StudentResponse(
        Long id,
        String studentId,
        String fullName,
        String email,
        String phone,
        String department,
        LocalDate admissionDate,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
