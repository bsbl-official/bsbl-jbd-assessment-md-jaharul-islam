package com.johurulislam.educationmanagementsystemwms.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CourseRequest(
        @NotBlank(message = "Course code is required")
        String courseCode,

        @Size(max = 100, message = "Course name must not exceed 100 characters")
        String courseName,

        @Min(value = 1, message = "Credit must be at least 1")
        Integer credit
) {}
