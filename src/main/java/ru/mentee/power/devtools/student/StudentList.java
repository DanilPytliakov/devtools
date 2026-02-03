package ru.mentee.power.devtools.student;

import java.util.List;
import java.util.ArrayList;

public class StudentList {
    private List<Student> studentList;  // нарушение: snake_case

    public StudentList() {
        studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (student != null) {  // нарушение: нет пробела после if
            studentList.add(student);
            System.out.println("Debug: student was added");
        }
    }

    public List<Student> getStudentsByCity(String city) {
        /*
        for (Student s : studentList) {
            if(s.city().equals(city)){
                studentList.add(s);
        }
        return.studentList;
        */
        return studentList.stream().
        filter(s -> s.city().equals(city)).
        toList();

    }
}