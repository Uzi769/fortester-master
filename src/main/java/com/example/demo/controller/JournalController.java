package com.example.demo.controller;

import com.example.demo.dao.model.journal.JournalInput;
import com.example.demo.dao.model.journal.JournalOutput;
import com.example.demo.dao.model.student.StudentOutput;
import com.example.demo.service.journal.JournalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JournalController {

    private final JournalService journalService;

    @PostMapping(value = "/journal")
    @ResponseStatus(HttpStatus.CREATED)
    public JournalOutput create(@RequestBody @Valid JournalInput journalInput) {
        return journalService.create(journalInput);
    }

    @GetMapping(value = "/journal/{rating}")
    public List<JournalOutput> getByRating(@PathVariable("rating") int rating) {
        return journalService.findByRating(rating);
    }

    @GetMapping(value = "/journals")
    public List<JournalOutput> getAll() {
        return journalService.findAll();
    }
}
