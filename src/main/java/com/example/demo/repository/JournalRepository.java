package com.example.demo.repository;

import com.example.demo.dao.entity.Journal;
import com.example.demo.dao.model.journal.JournalOutput;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JournalRepository extends JpaRepository<Journal, Long> {
    List<Journal> findAllByRating(int rating);
}
