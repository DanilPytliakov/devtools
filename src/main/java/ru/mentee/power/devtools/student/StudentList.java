package ru.mentee.power.devtools.student;

import java.util.ArrayList;  // порядок импортов нарушен
import java.util.List;

public class StudentList {
    private List<Student> studentList;  // нарушение: snake_case

    // лишняя пустая строка
    public StudentList() {
        studentList = new ArrayList<>();
    }

    // нарушение: имя метода
    public void addStudent(Student student) {
        if (student != null) {  // нарушение: нет пробела после if
            studentList.add(student);
        }
    }

    // нарушение: длинная строка (>120 символов)
    public List<Student> getStudentsByCity(String city) {
        return studentList.stream().
                filter(s -> s.city().equals(city)).toList();
    }
}