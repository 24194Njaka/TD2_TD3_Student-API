package com.td2.student_api.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    private String reference;
    private String firstName;
    private String lastName;
    private int age;
}
