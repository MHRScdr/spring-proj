package org.springproj.springproj.Student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudent(){
        return List.of(
                new Student(
                        1L,
                        20,
                        "Mehrsa",
                        "mehrsahosseini2005@gmail.com",
                        LocalDate.of(2005,6,5)
                )
        );
    }
}
