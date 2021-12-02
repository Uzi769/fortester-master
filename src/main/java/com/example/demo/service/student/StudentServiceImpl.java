package com.example.demo.service.student;

import com.example.demo.dao.entity.Student;
import com.example.demo.dao.mapper.StudentMapper;
import com.example.demo.dao.model.student.StudentInput;
import com.example.demo.dao.model.student.StudentOutput;
import com.example.demo.dao.model.student.StudentSearchByName;
import com.example.demo.exception.ConflictException;
import com.example.demo.exception.UnprocessableEntity;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.teacher.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final TeacherService teacherService;

    @Override
    public StudentOutput findByName(String name) {
        if (name.length() < 11) {
            throw new UnprocessableEntity("");
        }
        Student student = studentRepository.findByFullName(name).orElseThrow(() -> {
            log.error("Student not found");
            return new ConflictException("Student not found");
        });
        return studentMapper.toStudentOutput(student);
    }

    @Override
    public List<StudentOutput> findAll() {
        List<Student> list = studentRepository.findAll();
        return list.stream().map(studentMapper::toStudentOutput)
                .collect(Collectors.toList());
    }

    @Override
    public StudentOutput create(StudentInput studentInput) {
        if (studentInput.getFullName().length() >= 10) {
            Student newStudent = studentMapper.toStudent(studentInput);
            Student savedStudent = studentRepository.save(newStudent);
            return studentMapper.toStudentOutput(savedStudent);
        } else {
            throw new UnprocessableEntity("Full name is too short");
        }

    }

    @Override
    @Transactional
    public List<StudentOutput> findAllByTeacherId(Long id) {
        List <Student> list = teacherService.getById(id).getStudents();
        return list.stream().map(student -> studentMapper.toStudentOutput(student)).collect(Collectors.toList());
    }
}
