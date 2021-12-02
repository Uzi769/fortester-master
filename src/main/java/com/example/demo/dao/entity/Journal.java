package com.example.demo.dao.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "journal")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Journal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "rating")
    private int rating;

    @NotEmpty(message = "Предмет не может быть пустым")
    @Column(name = "academic_subject")
    private String academicSubject;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "student_id")
    private Student student;

}
