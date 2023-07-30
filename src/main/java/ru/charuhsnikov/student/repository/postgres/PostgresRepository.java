package ru.charuhsnikov.student.repository.postgres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.charuhsnikov.student.entity.Student;

import java.util.List;

public interface PostgresRepository extends JpaRepository<Student, Long> {
    @Query("SELECT e FROM Student e WHERE LOWER(e.name) LIKE LOWER(concat('%', :name, '%'))")
    List<Student> findByNameIgnoreCase(String name);
}
