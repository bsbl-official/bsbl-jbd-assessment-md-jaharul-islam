package com.johurulislam.educationmanagementsystemwms.repo;

import com.johurulislam.educationmanagementsystemwms.model.Course;
import com.johurulislam.educationmanagementsystemwms.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    @Query("SELECT COUNT(e) > 0 FROM Enrollment e WHERE e.student.id = :studentId AND e.course.id = :courseId AND e.semester = :semester")
    boolean existsByStudentIdAndCourseIdAndSemester(@Param("studentId") Long studentId, @Param("courseId") Long courseId, @Param("semester") String semester);

    @Query("SELECT COUNT(e) FROM Enrollment e WHERE e.student.id = :studentId AND e.semester = :semester")
    long countByStudentIdAndSemester(@Param("studentId") Long studentId, @Param("semester") String semester);

    @Query("SELECT e.course FROM Enrollment e WHERE e.student.id = :studentId")
    List<Course> findCoursesByStudentId(@Param("studentId") Long studentId);
}
