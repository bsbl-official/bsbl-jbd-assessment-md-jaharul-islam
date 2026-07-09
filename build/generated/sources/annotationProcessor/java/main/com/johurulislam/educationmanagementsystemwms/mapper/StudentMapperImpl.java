package com.johurulislam.educationmanagementsystemwms.mapper;

import com.johurulislam.educationmanagementsystemwms.dto.StudentRequest;
import com.johurulislam.educationmanagementsystemwms.dto.StudentResponse;
import com.johurulislam.educationmanagementsystemwms.model.Student;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-09T16:52:18+0600",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-java-compiler-worker-9.5.1.jar, environment: Java 21.0.7 (Amazon.com Inc.)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student toEntity(StudentRequest request) {
        if ( request == null ) {
            return null;
        }

        Student student = new Student();

        student.setStudentId( request.studentId() );
        student.setFullName( request.fullName() );
        student.setEmail( request.email() );
        student.setPhone( request.phone() );
        student.setDepartment( request.department() );
        student.setAdmissionDate( request.admissionDate() );

        return student;
    }

    @Override
    public StudentResponse toResponse(Student student) {
        if ( student == null ) {
            return null;
        }

        Long id = null;
        String studentId = null;
        String fullName = null;
        String email = null;
        String phone = null;
        String department = null;
        LocalDate admissionDate = null;
        LocalDateTime createdAt = null;
        LocalDateTime updatedAt = null;

        id = student.getId();
        studentId = student.getStudentId();
        fullName = student.getFullName();
        email = student.getEmail();
        phone = student.getPhone();
        department = student.getDepartment();
        admissionDate = student.getAdmissionDate();
        createdAt = student.getCreatedAt();
        updatedAt = student.getUpdatedAt();

        StudentResponse studentResponse = new StudentResponse( id, studentId, fullName, email, phone, department, admissionDate, createdAt, updatedAt );

        return studentResponse;
    }
}
