package com.example.demo.service.teacher;

import com.example.demo.dao.entity.Student;
import com.example.demo.dao.entity.Teacher;
import com.example.demo.dao.mapper.TeacherMapper;
import com.example.demo.dao.model.student.StudentOutput;
import com.example.demo.dao.model.teacher.TeacherInput;
import com.example.demo.dao.model.teacher.TeacherOutput;
import com.example.demo.dao.model.teacher.TeacherSearchByName;
import com.example.demo.dao.model.teacher.TeacherUpdate;
import com.example.demo.exception.ConflictException;
import com.example.demo.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService{

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    @Override
    public TeacherOutput findById(Long id) {
        if (id == null) {
            log.error("Id cannot be null");
            throw new ConflictException("Id cannot be null");
        }
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> {
            log.error("Teacher not found");
            return new ConflictException("Teacher not found");
        });
        return teacherMapper.toTeacherOutput(teacher);
    }

    @Override
    public void deleteTeacher(Long id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> {
            log.error("Teacher not found");
            return new ConflictException("Teacher not found");
        });
        teacherRepository.delete(teacher);
        log.info("Teacher was deleted");
    }

    @Override
    public List<TeacherOutput> findAll() {
        List<Teacher> list = teacherRepository.findAll();
        return list.stream().map(teacherMapper::toTeacherOutput)
                .collect(Collectors.toList());
    }

    @Override
    public TeacherOutput create(TeacherInput teacherInput) {
        Teacher newTeacher = teacherMapper.toTeacher(teacherInput);
        Teacher savedTeacher = teacherRepository.save(newTeacher);
        return teacherMapper.toTeacherOutput(savedTeacher);
    }

    @Override
    public TeacherOutput update(TeacherUpdate teacherUpdate, Long id) {
        Teacher fetchedTeacher = teacherRepository.findById(id).orElseThrow(() -> {
            log.error("Teacher not found");
            return new ConflictException("Teacher not found");
        });
        updateTeacher(fetchedTeacher, teacherUpdate);
        teacherRepository.save(fetchedTeacher);

        return  teacherMapper.toTeacherOutput(fetchedTeacher);
    }

    private void updateTeacher(Teacher teacher, TeacherUpdate teacherUpdate) {
        if (teacherUpdate.getFullName() != null && !teacher.getFullName().equals(teacherUpdate.getFullName())) {
            teacher.setFullName(teacherUpdate.getFullName());
        }
        if (teacherUpdate.getAcademicSubject() != null && !teacher.getAcademicSubject().equals(teacherUpdate.getAcademicSubject())) {
            teacher.setAcademicSubject(teacherUpdate.getAcademicSubject());
        }
        if (teacherUpdate.getDate() != null && teacher.getDate() != null && !teacher.getDate().equals(teacherUpdate.getDate())) {
            teacher.setDate(teacherUpdate.getDate());
        }
        if (teacherUpdate.getDate() != null && teacher.getDate() == null) {
            teacher.setDate(teacherUpdate.getDate());
        }
        if (teacherUpdate.getExperience() != null && teacher.getExperience() != null && !teacher.getExperience().equals(teacherUpdate.getExperience())) {
            teacher.setExperience(teacherUpdate.getExperience());
        }
        if (teacherUpdate.getExperience() != null && teacher.getExperience() == null) {
            teacher.setExperience(teacherUpdate.getExperience());
        }
    }

    @Override
    public List<TeacherOutput> findByName(String name) {
        List<Teacher> teachers = teacherRepository.findAllByFullName("%" + name + "%");

        return teachers.stream().map(teacher -> teacherMapper.toTeacherOutput(teacher)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Teacher getById(Long id) {
        return teacherRepository.getById(id);
    }
}
