package com.example.demo.service.student;

import com.example.demo.dao.model.student.StudentInput;
import com.example.demo.dao.model.student.StudentOutput;
import com.example.demo.dao.model.student.StudentSearchByName;
import com.example.demo.dao.model.teacher.TeacherInput;
import com.example.demo.dao.model.teacher.TeacherOutput;
import com.example.demo.dao.model.teacher.TeacherUpdate;

import java.util.List;

public interface StudentService {

    StudentOutput findByName(String name);

    List<StudentOutput> findAll();

    StudentOutput create(StudentInput studentInput);

    List<StudentOutput> findAllByTeacherId(Long id);
}
