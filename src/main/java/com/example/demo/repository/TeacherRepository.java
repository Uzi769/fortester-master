package com.example.demo.repository;

import com.example.demo.dao.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("select s from Teacher as s where s.fullName like :fullName")
    List<Teacher> findAllByFullName(String fullName);
}
