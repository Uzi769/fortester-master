package com.example.demo.dao.model.teacher;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherOutput {
    private Long id;
    private String fullName;
    private String academicSubject;
    private String experience;
    private LocalDate date;
}
