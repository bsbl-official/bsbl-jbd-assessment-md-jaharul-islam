package com.johurulislam.educationmanagementsystemwms.dto;

import jakarta.validation.constraints.NotBlank;

public record EnrollmentRequest(
        @NotBlank(message = "Student ID is required")
        String studentId,

        @NotBlank(message = "Course Code is required")
        String courseCode,

        @NotBlank(message = "Semester is required")
        String semester
) {}
