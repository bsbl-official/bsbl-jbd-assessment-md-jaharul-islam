package com.johurulislam.educationmanagementsystemwms.service;

import com.johurulislam.educationmanagementsystemwms.dto.StudentRequest;
import com.johurulislam.educationmanagementsystemwms.dto.StudentResponse;

import java.util.List;

public interface StudentService {
    StudentResponse createStudent(StudentRequest request);

    List<StudentResponse> getAllStudents();

    StudentResponse getStudentByStudentId(String studentId);

    StudentResponse updateStudent(String studentId, StudentRequest request);

    void deleteStudent(String studentId);
}
