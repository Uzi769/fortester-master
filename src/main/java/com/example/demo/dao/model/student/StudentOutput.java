package com.example.demo.dao.model.student;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentOutput {
    private Long id;
    private String fullName;
    private String grade;
}
