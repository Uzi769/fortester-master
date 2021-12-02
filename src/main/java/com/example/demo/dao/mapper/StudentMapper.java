package com.example.demo.dao.mapper;

import com.example.demo.dao.entity.Student;
import com.example.demo.dao.model.student.StudentInput;
import com.example.demo.dao.model.student.StudentOutput;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toStudent(StudentInput studentInput);

    StudentOutput toStudentOutput(Student student);
}
