package com.ravi.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8StreamFunctionsTest {
    public static void main(String[] args) {
        List<Student> students = Stream.of(
                new Student(1, 1, 20, "Ravi", "Electronics Engineering", "Male", "Hyderabad",
                        Arrays.asList("1234556", "1233457")),
                new Student(2, 5, 19, "Virat", "Mechanical Engineering", "Male", "Mumbai",
                        Arrays.asList("1233456", "1235457")),
                new Student(3, 4, 21, "Rohit", "Civil Engineering", "Male", "Delhi",
                        Arrays.asList("1233456", "123457")),
                new Student(4, 3, 22, "Swathi", "Electronics Engineering", "Female", "Hyderabad",
                        Arrays.asList("1232456", "1234517")),
                new Student(5, 6, 20, "Ashwin", "Computer Engineering", "Male", "Bangalore",
                        Arrays.asList("1234546", "1234557")),
                new Student(6, 2, 19, "Priyanka", "Electronics Engineering", "Female", "Vizag",
                        Arrays.asList("1234561", "1234573"))
        ).toList();

        //Find top 3 students by ranks
        List<Student> studentsTop3 = students.stream().filter(s -> s.getRank() <= 3).collect(Collectors.toList());
        System.out.println(studentsTop3);

        //Find students from hyderabad and sort by name
        List<Student> hyderabad = students.stream().filter(s -> s.getCity().equals("Hyderabad"))
                .sorted(Comparator.comparing(Student::getName, Comparator.reverseOrder())).collect(Collectors.toList());
        System.out.println(hyderabad);

        //Find all department names
        List<String> departments = students.stream().map(Student::getDepartment).distinct().collect(Collectors.toList());
        System.out.println(departments);
        Set<String> departmentSet = students.stream().map(Student::getDepartment).collect(Collectors.toSet());
        System.out.println(departmentSet);

        //Find all the contact members
        List<String> contacts = students.stream().flatMap(s -> s.getContacts().stream()).collect(Collectors.toList());
        System.out.println(contacts);

        //Group the students by department
        Map<String, Long> studentsByDept = students.stream().collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()));
        System.out.println(studentsByDept);

        //Find the department with maximum students
        Map.Entry<String, Long> deptWithMaxStudents = students.stream().collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting())).
                entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println(deptWithMaxStudents);

        //Find the average age of male and female
        Map<String, Double> avgAge = students.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        System.out.println(avgAge);

        //Find the highest rank in each department
        Map<String, Optional<Student>> bestRankForDept = students.stream().collect(Collectors.groupingBy(Student::getDepartment, Collectors.minBy(Comparator.comparing(Student::getRank))));
        System.out.println(bestRankForDept);

        //Find second ranker
        Student secondRanker = students.stream().sorted(Comparator.comparing(Student::getRank)).skip(1).findAny().get();
        System.out.println(secondRanker);

        Map<String, Long> collect = Arrays.stream(students.stream().findFirst().get().getDepartment().split("")).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
    }
}
