package com.johurulislam.educationmanagementsystemwms.mapper;

import com.johurulislam.educationmanagementsystemwms.dto.EnrollmentResponse;
import com.johurulislam.educationmanagementsystemwms.model.Enrollment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {

    @Mapping(target = "studentId", source = "student.studentId")
    @Mapping(target = "studentName", source = "student.fullName")
    @Mapping(target = "courseId", source = "course.id")
    @Mapping(target = "courseCode", source = "course.courseCode")
    @Mapping(target = "courseName", source = "course.courseName")
    EnrollmentResponse toResponse(Enrollment enrollment);
}
