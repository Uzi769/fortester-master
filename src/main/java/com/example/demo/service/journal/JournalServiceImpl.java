package com.example.demo.service.journal;

import com.example.demo.dao.entity.Journal;
import com.example.demo.dao.mapper.JournalMapper;
import com.example.demo.dao.mapper.StudentMapper;
import com.example.demo.dao.model.journal.JournalInput;
import com.example.demo.dao.model.journal.JournalOutput;
import com.example.demo.repository.JournalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class JournalServiceImpl implements JournalService {

    private final JournalRepository journalRepository;
    private final JournalMapper journalMapper;

    @Override
    public List<JournalOutput> findByRating(int rating) {
        return journalRepository.findAllByRating(rating).stream()
                .map(journal -> journalMapper.toJournalOutput(journal))
                .collect(Collectors.toList());
    }

    @Override
    public List<JournalOutput> findAll() {
        return journalRepository.findAll().stream()
                .map(journal -> journalMapper.toJournalOutput(journal))
                .collect(Collectors.toList());
    }

    @Override
    public JournalOutput create(JournalInput journalInput) {
        Journal journal = journalMapper.toJournal(journalInput);
        Journal savedJournal = journalRepository.save(journal);
        return journalMapper.toJournalOutput(savedJournal);
    }
}
