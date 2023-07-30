package ru.charuhsnikov.student.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.charuhsnikov.student.entity.Student;
import ru.charuhsnikov.student.repository.h2.H2Repository;
import ru.charuhsnikov.student.repository.postgres.PostgresRepository;

import java.util.List;

@Service
@Transactional
public class StudentService {

    private final H2Repository h2Repository;
    private final PostgresRepository postgresRepository;

    public StudentService(H2Repository h2Repository, PostgresRepository postgresRepository) {
        this.h2Repository = h2Repository;
        this.postgresRepository = postgresRepository;
    }

    public List<Student> findAllOrOne(String name) {
        if (name == null) {
            return h2Repository.findAll();
        }
        return postgresRepository.findByNameIgnoreCase(name);
    }

    public void save(Student student) {
        h2Repository.save(student);
        postgresRepository.save(student);
    }

    public void delete(Student student) {
        h2Repository.delete(student);
        postgresRepository.delete(student);
    }

    public Student update(Student student) {
        Student updateStudent = h2Repository.findById(student.getId()).orElseThrow(RuntimeException::new);
        updateStudent.setActual(false);
        h2Repository.save(updateStudent);

        return postgresRepository.save(student);
    }
}
