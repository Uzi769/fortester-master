package com.example.demo.dao.model.teacher;

import lombok.*;

import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherSearchByName {
    private String fullName;
}
