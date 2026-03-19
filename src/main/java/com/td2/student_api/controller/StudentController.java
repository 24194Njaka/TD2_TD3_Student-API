package com.td2.student_api.controller;


import com.td2.student_api.entity.Student;
import com.td2.student_api.server.StudentServer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    @GetMapping(value = "/students", produces = {"text/plain", "application/json"})
    public ResponseEntity <?> getStudents( @RequestHeader ("Accept") String accept) {
        if (accept.equals("text/plain")) {
            String names = studentServer.getStudents()
                    .stream()
                    .map(student -> student.getFirstName()+" "+student.getLastName())
                    .collect(Collectors.joining(", "));

            return ResponseEntity.ok()
                    .header("content-type", "text/plain")
                    .body(names);
        } else  {
            return ResponseEntity
                    .status(415)
                    .body("format non supportée");



        }
    }

}
