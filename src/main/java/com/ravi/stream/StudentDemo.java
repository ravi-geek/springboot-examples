package com.ravi.stream;

import java.util.Arrays;

public class StudentDemo {
    public static void main(String[] args) {
        Student student1 = new Student(1, 1, 20, "Ravi", "Electronics Engineering", "Male", "Hyderabad",
                Arrays.asList("1234556", "1233457"));
        Student student2 = new Student(1, 1, 20, "Ravi", "Electronics Engineering", "Male", "Hyderabad",
                Arrays.asList("1234556", "1233457"));
        System.out.println(student1.equals(student2));
        System.out.println(student1 == student2);
    }
}
