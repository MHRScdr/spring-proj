package org.springproj.springproj.Student;

import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("Email already in use");
        }
        studentRepository.save(student);
        System.out.println(student);
    }

    public void deleteStudent(Long studentID) {
        boolean exist = studentRepository.existsById(studentID);
        if(!exist){
            throw new IllegalStateException("Student with id "+ studentID + " does not exist");
        }
        studentRepository.deleteById(studentID);
    }

    @Transactional
    public void updateStudent(Long studentId,
                              String name,
                              String email) {
        Student student = studentRepository.findById(studentId).
                orElseThrow(() -> new IllegalStateException("Student with id "+ studentId + " does not exist"));
        if(name != null &&
           name.length() > 0 &&
           !Objects.equals(name, student.getName())){
            student.setName(name);
        }
        if(email != null &&
           email.length() > 0 &&
           !Objects.equals(email, student.getEmail())){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("Email already in use");
            }
            student.setEmail(email);
        }
    }
}
