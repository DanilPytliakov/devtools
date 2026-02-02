package ru.mentee.power.devtools.student;

import java.util.ArrayList;  // порядок импортов нарушен
import java.util.List;

public class StudentList {
    private List<Student> student_list;  // нарушение: snake_case

    // лишняя пустая строка
    public StudentList() {
        student_list = new ArrayList<>();
    }

    // нарушение: имя метода
    public void addStudent(Student student) {
        if(student != null)  // нарушение: нет пробела после if
            student_list.add(student);
    }

    // нарушение: длинная строка (>120 символов)
    public List<Student> getStudentsByCity(String city) {
        return student_list.stream().filter(s -> s.city().equals(city)).toList();
    }
}