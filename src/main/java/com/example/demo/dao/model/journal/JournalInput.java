package com.example.demo.dao.model.journal;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JournalInput {

    @NonNull
    @Min(value = 1, message = "Оценка находится в промежутке от 1 до 5")
    @Max(value = 5, message = "Оценка находится в промежутке от 1 до 5")
    private int rating;

    @NotEmpty(message = "Предмет не может быть пустым")
    private String academicSubject;
    private Long studentId;
}
