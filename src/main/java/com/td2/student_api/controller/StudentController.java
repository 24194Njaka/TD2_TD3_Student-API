package com.td2.student_api.controller;


import com.td2.student_api.entity.Student;
import com.td2.student_api.server.StudentServer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController {

    private final StudentServer studentServer;


    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(@RequestParam String name) {
        return ResponseEntity.ok("welcome"+ " " + name);
    }

    @PostMapping("/students")
    public ResponseEntity<List<Student>> addStudent(@RequestBody List<Student> newStudents) {
        return ResponseEntity.ok(studentServer.addStudents(newStudents));

    }

}
