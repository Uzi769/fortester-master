package com.example.demo.controller;

import com.example.demo.dao.model.student.StudentInput;
import com.example.demo.dao.model.student.StudentOutput;
import com.example.demo.dao.model.student.StudentSearchByName;
import com.example.demo.service.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentController {


    private final StudentService studentService;

    @GetMapping(value = "/student")
    public StudentOutput getByName(@RequestParam String name) {
        return studentService.findByName(name);
    }

    @GetMapping(value = "/students")
    public List<StudentOutput> getAll() {
        return studentService.findAll();
    }


    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentOutput create(@RequestBody @Valid StudentInput studentInput) {
        return studentService.create(studentInput);
    }

    @GetMapping(value = "/student-by-teacher/{id}")
    public List<StudentOutput> getByTeacherId(@PathVariable("id") Long id) {
        return studentService.findAllByTeacherId(id);
    }
}
