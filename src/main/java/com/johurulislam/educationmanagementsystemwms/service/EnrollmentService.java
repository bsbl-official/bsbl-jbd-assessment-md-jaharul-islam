package com.johurulislam.educationmanagementsystemwms.service;

import com.johurulislam.educationmanagementsystemwms.dto.CourseResponse;
import com.johurulislam.educationmanagementsystemwms.dto.EnrollmentRequest;
import com.johurulislam.educationmanagementsystemwms.dto.EnrollmentResponse;

import java.util.List;

public interface EnrollmentService {
    EnrollmentResponse createEnrollment(EnrollmentRequest request);

    List<EnrollmentResponse> getAllEnrollments();

    EnrollmentResponse getEnrollmentById(Long id);

    List<CourseResponse> getCoursesByStudentId(String studentId);
}
