package com.johurulislam.educationmanagementsystemwms.repo;

import com.johurulislam.educationmanagementsystemwms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByStudentId(String studentId);

    boolean existsByEmail(String email);

    Optional<Student> findByStudentId(String studentId);
}
