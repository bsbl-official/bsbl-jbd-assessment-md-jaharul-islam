package com.johurulislam.educationmanagementsystemwms.service.impl;

import com.johurulislam.educationmanagementsystemwms.dto.CourseResponse;
import com.johurulislam.educationmanagementsystemwms.dto.EnrollmentRequest;
import com.johurulislam.educationmanagementsystemwms.dto.EnrollmentResponse;
import com.johurulislam.educationmanagementsystemwms.exception.DuplicateResourceException;
import com.johurulislam.educationmanagementsystemwms.exception.ResourceNotFoundException;
import com.johurulislam.educationmanagementsystemwms.mapper.CourseMapper;
import com.johurulislam.educationmanagementsystemwms.mapper.EnrollmentMapper;
import com.johurulislam.educationmanagementsystemwms.model.Course;
import com.johurulislam.educationmanagementsystemwms.model.Enrollment;
import com.johurulislam.educationmanagementsystemwms.model.Student;
import com.johurulislam.educationmanagementsystemwms.repo.CourseRepository;
import com.johurulislam.educationmanagementsystemwms.repo.EnrollmentRepository;
import com.johurulislam.educationmanagementsystemwms.repo.StudentRepository;
import com.johurulislam.educationmanagementsystemwms.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentMapper enrollmentMapper;
    private final CourseMapper courseMapper;

    @Override
    public EnrollmentResponse createEnrollment(EnrollmentRequest request) {
        Student student = studentRepository.findByStudentId(request.studentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student", request.studentId()));

        Course course = courseRepository.findByCourseCode(request.courseCode())
                .orElseThrow(() -> new ResourceNotFoundException("Course", request.courseCode()));

        Long studentEntityId = student.getId();
        Long courseEntityId = course.getId();

        if (enrollmentRepository.existsByStudentIdAndCourseIdAndSemester(
                studentEntityId, courseEntityId, request.semester())) {
            throw new DuplicateResourceException(
                    "Student is already enrolled in this course for semester " + request.semester());
        }

        long courseCount = enrollmentRepository.countByStudentIdAndSemester(
                studentEntityId, request.semester());
        if (courseCount >= 5) {
            throw new IllegalStateException("Student cannot enroll in more than 5 courses per semester");
        }

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setSemester(request.semester());
        enrollment.setEnrollmentDate(LocalDate.now());

        Enrollment saved = enrollmentRepository.save(enrollment);
        return enrollmentMapper.toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EnrollmentResponse> getAllEnrollments() {
        return enrollmentRepository.findAll()
                .stream()
                .map(enrollmentMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public EnrollmentResponse getEnrollmentById(Long id) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment", id));
        return enrollmentMapper.toResponse(enrollment);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseResponse> getCoursesByStudentId(String studentId) {
        Student student = studentRepository.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student", studentId));

        List<Course> courses = enrollmentRepository.findCoursesByStudentId(student.getId());
        return courses.stream()
                .map(courseMapper::toResponse)
                .toList();
    }
}
