package com.example.demo.dao.model.teacher;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherInput {
    @NotEmpty(message = "Поле имя не может быть пустым")
    private String fullName;

    @NotEmpty(message = "Поле предмет не может быть пустым")
    private String academicSubject;
    private String experience;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate date;
}
