package com.example.demo.dao.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "full_name")
    private String fullName;

    @NotEmpty
    @Column(name = "grade")
    private String grade;

    @ManyToMany(mappedBy = "students", fetch = FetchType.LAZY)
    private List<Teacher> teachers;

    @OneToMany(mappedBy = "student")
    private List<Journal> journals;
}
