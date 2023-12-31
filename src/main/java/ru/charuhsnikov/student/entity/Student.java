package ru.charuhsnikov.student.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private int age;
    private boolean isMale;
    private double scholarship;

    public Student(String name, int age, boolean isMale, double scholarship) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
        this.scholarship = scholarship;
    }
}
