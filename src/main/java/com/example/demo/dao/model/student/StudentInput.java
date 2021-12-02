package com.example.demo.dao.model.student;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentInput {
    @NotEmpty(message = "Поле имя не может быть пустым")
    @Column(name = "full_name")
    private String fullName;
    @NotEmpty(message = "Поле класс не может быть пустым")
    @Column(name = "grade")
    private String grade;
}
