package com.ravi.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private int rank;
    private int age;
    private String name;
    private String department;
    private String gender;
    private String city;
    private List<String> contacts;
}
