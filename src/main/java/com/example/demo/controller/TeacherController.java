package com.example.demo.controller;

import com.example.demo.dao.model.student.StudentOutput;
import com.example.demo.dao.model.student.StudentSearchByName;
import com.example.demo.dao.model.teacher.TeacherInput;
import com.example.demo.dao.model.teacher.TeacherOutput;
import com.example.demo.dao.model.teacher.TeacherSearchByName;
import com.example.demo.dao.model.teacher.TeacherUpdate;
import com.example.demo.service.teacher.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping(value = "/teacher/{id}")
    public TeacherOutput getById(@PathVariable("id") Long id) {
        return teacherService.findById(id);
    }

    @GetMapping(value = "/teachers")
    public List<TeacherOutput> getAll() {
        return teacherService.findAll();
    }

    @DeleteMapping(value = "/teacher/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        teacherService.deleteTeacher(id);
    }

    @PostMapping("/teacher")
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherOutput create(@RequestBody @Valid TeacherInput teacherInput) {
        return teacherService.create(teacherInput);
    }

    @PutMapping(value = "/teacher/{id}")
    public TeacherOutput update(@PathVariable("id") Long id, @RequestBody @Valid TeacherUpdate teacherUpdate) {
        return teacherService.update(teacherUpdate, id);
    }

    @GetMapping(value = "/search")
    public List<TeacherOutput> getByName(@RequestParam String name) {
        return teacherService.findByName(name);
    }
}
