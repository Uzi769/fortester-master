package com.example.demo.service.journal;

import com.example.demo.dao.model.journal.JournalInput;
import com.example.demo.dao.model.journal.JournalOutput;

import java.util.List;

public interface JournalService {

    List<JournalOutput> findByRating(int rating);

    List<JournalOutput> findAll();

    JournalOutput create(JournalInput journalInput);
}
