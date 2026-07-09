package com.johurulislam.educationmanagementsystemwms.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record EnrollmentResponse(
        Long id,
        String studentId,
        String studentName,
        Long courseId,
        String courseCode,
        String courseName,
        String semester,
        LocalDate enrollmentDate,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
