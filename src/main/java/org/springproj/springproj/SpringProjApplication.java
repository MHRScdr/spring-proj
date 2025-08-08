package org.springproj.springproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springproj.springproj.Student.Student;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class SpringProjApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProjApplication.class, args);
    }

//    @GetMapping
//    public String Hello(){
//        return "Hello Werld👋👋";
//    }



}
