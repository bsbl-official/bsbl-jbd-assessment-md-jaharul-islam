package com.johurulislam.educationmanagementsystemwms.dto;

import java.time.LocalDateTime;

public record CourseResponse(
        Long id,
        String courseCode,
        String courseName,
        Integer credit,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
