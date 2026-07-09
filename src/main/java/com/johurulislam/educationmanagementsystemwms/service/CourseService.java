package com.johurulislam.educationmanagementsystemwms.service;

import com.johurulislam.educationmanagementsystemwms.dto.CourseRequest;
import com.johurulislam.educationmanagementsystemwms.dto.CourseResponse;

import java.util.List;

public interface CourseService {
    CourseResponse createCourse(CourseRequest request);

    List<CourseResponse> getAllCourses();

    CourseResponse getCourseById(Long id);

    CourseResponse getCourseByCode(String courseCode);

    CourseResponse updateCourse(Long id, CourseRequest request);

    void deleteCourse(Long id);
}
