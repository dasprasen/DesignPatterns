package com.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Johnny", "Jane", "Jack", "Jill");
        Map<Integer, List<String>> groupedByLength = names.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(groupedByLength);


        List<Student> students = new ArrayList<>();
        students.add(new Student(10,12,"abc"));
        students.add(new Student(2,13,"xyz"));
        students.add(new Student(1,9,"pqr"));
        students.add(new Student(15,15,"xyz"));
        students.add(new Student(8,7,"def"));

        Collections.sort(students, new GenericComparator<>(Student::getAge));
        Collections.sort(students, new GenericComparator<>(Student::getName));
        Collections.sort(students, new GenericComparator<>(Student::getRollNum));

        for(Student student: students)
            System.out.println(student);
    }

}
