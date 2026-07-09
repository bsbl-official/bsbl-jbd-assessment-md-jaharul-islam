package com.johurulislam.educationmanagementsystemwms.service.impl;

import com.johurulislam.educationmanagementsystemwms.dto.CourseRequest;
import com.johurulislam.educationmanagementsystemwms.dto.CourseResponse;
import com.johurulislam.educationmanagementsystemwms.exception.DuplicateResourceException;
import com.johurulislam.educationmanagementsystemwms.exception.ResourceNotFoundException;
import com.johurulislam.educationmanagementsystemwms.mapper.CourseMapper;
import com.johurulislam.educationmanagementsystemwms.model.Course;
import com.johurulislam.educationmanagementsystemwms.repo.CourseRepository;
import com.johurulislam.educationmanagementsystemwms.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public CourseResponse createCourse(CourseRequest request) {
        if (courseRepository.existsByCourseCode(request.courseCode())) {
            throw new DuplicateResourceException("Course code '" + request.courseCode() + "' already exists");
        }

        Course course = courseMapper.toEntity(request);
        Course saved = courseRepository.save(course);
        return courseMapper.toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseResponse> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CourseResponse getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course", id));
        return courseMapper.toResponse(course);
    }

    @Override
    @Transactional(readOnly = true)
    public CourseResponse getCourseByCode(String courseCode) {
        Course course = courseRepository.findByCourseCode(courseCode)
                .orElseThrow(() -> new ResourceNotFoundException("Course", courseCode));
        return courseMapper.toResponse(course);
    }

    @Override
    public CourseResponse updateCourse(Long id, CourseRequest request) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course", id));

        if (!course.getCourseCode().equals(request.courseCode())
                && courseRepository.existsByCourseCode(request.courseCode())) {
            throw new DuplicateResourceException("Course code '" + request.courseCode() + "' already exists");
        }

        course.setCourseCode(request.courseCode());
        course.setCourseName(request.courseName());
        course.setCredit(request.credit());

        Course saved = courseRepository.save(course);
        return courseMapper.toResponse(saved);
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course", id));
        courseRepository.delete(course);
    }
}
