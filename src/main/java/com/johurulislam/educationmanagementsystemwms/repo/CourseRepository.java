package com.johurulislam.educationmanagementsystemwms.repo;

import com.johurulislam.educationmanagementsystemwms.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    boolean existsByCourseCode(String courseCode);

    java.util.Optional<Course> findByCourseCode(String courseCode);
}
