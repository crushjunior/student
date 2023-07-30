package ru.charuhsnikov.student.repository.h2;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.charuhsnikov.student.entity.Student;

public interface H2Repository extends JpaRepository<Student, Long> {
}
