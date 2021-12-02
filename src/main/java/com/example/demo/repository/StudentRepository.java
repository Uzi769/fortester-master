package com.example.demo.repository;

import com.example.demo.dao.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByFullName(String fullName);
}
