package ru.charuhsnikov.student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.charuhsnikov.student.entity.Student;
import ru.charuhsnikov.student.repository.StudentRepository;

@SpringBootApplication
public class StudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(StudentRepository repository) {
        return (args) -> {

            repository.save(new Student("Jack", 23, true, 5000));
            repository.save(new Student("Chloe", 22, false, 3000));
            repository.save(new Student("Kim", 21, true, 4000));
            repository.save(new Student("David", 23, true, 4500));

        };
    }
}
