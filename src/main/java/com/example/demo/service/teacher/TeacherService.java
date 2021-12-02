package com.example.demo.service.teacher;

import com.example.demo.dao.entity.Teacher;
import com.example.demo.dao.model.student.StudentOutput;
import com.example.demo.dao.model.student.StudentSearchByName;
import com.example.demo.dao.model.teacher.TeacherInput;
import com.example.demo.dao.model.teacher.TeacherOutput;
import com.example.demo.dao.model.teacher.TeacherSearchByName;
import com.example.demo.dao.model.teacher.TeacherUpdate;

import java.util.List;

public interface TeacherService {

    TeacherOutput findById(Long id);

    void deleteTeacher(Long id);

    List<TeacherOutput> findAll();

    TeacherOutput create(TeacherInput teacherInput);

    TeacherOutput update(TeacherUpdate teacherUpdate, Long id);

    List<TeacherOutput> findByName(String name);

    Teacher getById(Long id);
}
