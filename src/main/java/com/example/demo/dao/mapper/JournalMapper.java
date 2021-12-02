package com.example.demo.dao.mapper;

import com.example.demo.dao.entity.Journal;
import com.example.demo.dao.entity.Student;
import com.example.demo.dao.model.journal.JournalInput;
import com.example.demo.dao.model.journal.JournalOutput;
import com.example.demo.dao.model.student.StudentInput;
import com.example.demo.dao.model.student.StudentOutput;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class JournalMapper {

    @Autowired
    protected StudentRepository studentRepository;

    @Autowired
    protected StudentMapper studentMapper;

    @Mapping(
            target = "student", expression = "java(studentRepository.getById(journalInput.getStudentId()))"
    )
    public abstract Journal toJournal(JournalInput journalInput);

    @Mapping(
            target = "studentOutput", expression = "java(studentMapper.toStudentOutput(journal.getStudent()))"
    )
    public abstract JournalOutput toJournalOutput(Journal journal);
}
