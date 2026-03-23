package com.td.student_api.controller;

import com.td.student_api.entity.Student;
import com.td.student_api.server.StudentServer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class StudentController {
    private final StudentServer studentServer;


    public StudentController(StudentServer studentServer) {
        this.studentServer = studentServer;
    }

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(@RequestParam(required = false) String name ) {
        if(name == null || name.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Paramètre manquant");
        } else  {
            return ResponseEntity.ok("Welcome " + name);

        }

    }

    @PostMapping("/students")
    public ResponseEntity<?> addStudent(@RequestBody List<Student> newStudents) {
        try{
            List<Student> result = studentServer.addStudents(newStudents);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);

        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("erruer servuer : "  + e.getMessage());

        }
    }
}
