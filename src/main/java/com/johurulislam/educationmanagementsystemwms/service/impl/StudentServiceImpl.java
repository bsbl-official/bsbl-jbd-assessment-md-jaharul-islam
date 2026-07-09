package com.johurulislam.educationmanagementsystemwms.service.impl;

import com.johurulislam.educationmanagementsystemwms.dto.StudentRequest;
import com.johurulislam.educationmanagementsystemwms.dto.StudentResponse;
import com.johurulislam.educationmanagementsystemwms.exception.DuplicateResourceException;
import com.johurulislam.educationmanagementsystemwms.exception.ResourceNotFoundException;
import com.johurulislam.educationmanagementsystemwms.mapper.StudentMapper;
import com.johurulislam.educationmanagementsystemwms.model.Student;
import com.johurulislam.educationmanagementsystemwms.repo.StudentRepository;
import com.johurulislam.educationmanagementsystemwms.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public StudentResponse createStudent(StudentRequest request) {
        if (studentRepository.existsByStudentId(request.studentId())) {
            throw new DuplicateResourceException("Student ID '" + request.studentId() + "' already exists");
        }
        if (studentRepository.existsByEmail(request.email())) {
            throw new DuplicateResourceException("Email '" + request.email() + "' already exists");
        }

        Student student = studentMapper.toEntity(request);
        Student saved = studentRepository.save(student);
        return studentMapper.toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public StudentResponse getStudentByStudentId(String studentId) {
        Student student = studentRepository.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student", studentId));
        return studentMapper.toResponse(student);
    }

    @Override
    public StudentResponse updateStudent(String studentId, StudentRequest request) {
        Student student = studentRepository.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student", studentId));

        if (!student.getStudentId().equals(request.studentId())
                && studentRepository.existsByStudentId(request.studentId())) {
            throw new DuplicateResourceException("Student ID '" + request.studentId() + "' already exists");
        }
        if (!student.getEmail().equals(request.email())
                && studentRepository.existsByEmail(request.email())) {
            throw new DuplicateResourceException("Email '" + request.email() + "' already exists");
        }

        student.setStudentId(request.studentId());
        student.setFullName(request.fullName());
        student.setEmail(request.email());
        student.setPhone(request.phone());
        student.setDepartment(request.department());
        student.setAdmissionDate(request.admissionDate());

        Student saved = studentRepository.save(student);
        return studentMapper.toResponse(saved);
    }

    @Override
    public void deleteStudent(String studentId) {
        Student student = studentRepository.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student", studentId));
        studentRepository.delete(student);
    }
}
