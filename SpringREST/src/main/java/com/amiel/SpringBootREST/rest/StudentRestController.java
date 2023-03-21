package com.amiel.SpringBootREST.rest;

import com.amiel.SpringBootREST.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> students;
    // define PostConstruct to load the student data ... only once
    @PostConstruct
    public void loadData(){
        this.students = new ArrayList<>();
        this.students.add(new Student("Poornima", "Patel"));
        this.students.add(new Student("Mario", "Rossi"));
        this.students.add(new Student("Mary", "Smith"));
    }
    // Define an enpoint for /students , return a list of students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return this.students;
    }
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        // check the student id again
        if((studentId >= this.students.size()) || studentId < 0){
           throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        // just index into the list
        return students.get(studentId);
    }

}
