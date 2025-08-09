package org.springproj.springproj.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student maryam = new Student(
                    "Maryam",
                    "maryam.jamal@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );

            Student Mehrsa = new Student(
                    "Mehrsa",
                    "mehrsahosseini2005@gmail.com",
                    LocalDate.of(2005, Month.JUNE, 5)
            );

            repository.saveAll(List.of(maryam, Mehrsa));
        };
    }
}
