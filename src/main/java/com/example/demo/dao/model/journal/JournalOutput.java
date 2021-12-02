package com.example.demo.dao.model.journal;

import com.example.demo.dao.model.student.StudentOutput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JournalOutput {
    private Long id;
    private int rating;
    private String academicSubject;
    private StudentOutput studentOutput;
}
