package com.example.demo.dao.mapper;

import com.example.demo.dao.entity.Teacher;
import com.example.demo.dao.model.teacher.TeacherInput;
import com.example.demo.dao.model.teacher.TeacherOutput;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    Teacher toTeacher(TeacherInput teacherInput);

    TeacherOutput toTeacherOutput(Teacher teacher);
}
