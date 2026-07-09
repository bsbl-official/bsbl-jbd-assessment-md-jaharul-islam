package com.johurulislam.educationmanagementsystemwms.mapper;

import com.johurulislam.educationmanagementsystemwms.dto.EnrollmentResponse;
import com.johurulislam.educationmanagementsystemwms.model.Course;
import com.johurulislam.educationmanagementsystemwms.model.Enrollment;
import com.johurulislam.educationmanagementsystemwms.model.Student;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-09T17:28:59+0600",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-java-compiler-worker-9.5.1.jar, environment: Java 21.0.7 (Amazon.com Inc.)"
)
@Component
public class EnrollmentMapperImpl implements EnrollmentMapper {

    @Override
    public EnrollmentResponse toResponse(Enrollment enrollment) {
        if ( enrollment == null ) {
            return null;
        }

        String studentId = null;
        String studentName = null;
        Long courseId = null;
        String courseCode = null;
        String courseName = null;
        Long id = null;
        String semester = null;
        LocalDate enrollmentDate = null;
        LocalDateTime createdAt = null;
        LocalDateTime updatedAt = null;

        studentId = enrollmentStudentStudentId( enrollment );
        studentName = enrollmentStudentFullName( enrollment );
        courseId = enrollmentCourseId( enrollment );
        courseCode = enrollmentCourseCourseCode( enrollment );
        courseName = enrollmentCourseCourseName( enrollment );
        id = enrollment.getId();
        semester = enrollment.getSemester();
        enrollmentDate = enrollment.getEnrollmentDate();
        createdAt = enrollment.getCreatedAt();
        updatedAt = enrollment.getUpdatedAt();

        EnrollmentResponse enrollmentResponse = new EnrollmentResponse( id, studentId, studentName, courseId, courseCode, courseName, semester, enrollmentDate, createdAt, updatedAt );

        return enrollmentResponse;
    }

    private String enrollmentStudentStudentId(Enrollment enrollment) {
        Student student = enrollment.getStudent();
        if ( student == null ) {
            return null;
        }
        return student.getStudentId();
    }

    private String enrollmentStudentFullName(Enrollment enrollment) {
        Student student = enrollment.getStudent();
        if ( student == null ) {
            return null;
        }
        return student.getFullName();
    }

    private Long enrollmentCourseId(Enrollment enrollment) {
        Course course = enrollment.getCourse();
        if ( course == null ) {
            return null;
        }
        return course.getId();
    }

    private String enrollmentCourseCourseCode(Enrollment enrollment) {
        Course course = enrollment.getCourse();
        if ( course == null ) {
            return null;
        }
        return course.getCourseCode();
    }

    private String enrollmentCourseCourseName(Enrollment enrollment) {
        Course course = enrollment.getCourse();
        if ( course == null ) {
            return null;
        }
        return course.getCourseName();
    }
}
