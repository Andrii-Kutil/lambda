package com.gmail.kutilandrej;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.Function;

public class StudentInfo {

  public static void main(String[] args) {
    Student student1 = new Student("Ivan", 'm', 22, 3, 8.3);
    Student student2 = new Student("Elena", 'f', 18, 1, 5);
    Student student3 = new Student("Andrej", 'm', 26, 2, 3);
    Student student4 = new Student("Dima", 'm', 40, 5, 10);
    Student student5 = new Student("Oksana", 'f', 38, 2, 4);
    Student student6 = new Student("Anton", 'm', 26, 4, 7);

    List<Student> students = new ArrayList<>();
    students.add(student1);
    students.add(student2);
    students.add(student3);
    students.add(student4);
    students.add(student5);
    students.add(student6);

    StudentInfo studentInfo = new StudentInfo();

    int[] test = new int[4];
    test[0] = 1;
    test[1] = 2;
    studentInfo.printStudent(students, student -> student.getAvgGrade() > test[0]);
    System.out.println("------------------");
    studentInfo.printStudent(students, student -> student.getAge() > test[1]);
    System.out.println("------------------");
    studentInfo.printStudent(students,
        student -> student.getAvgGrade() > 8 && student.getAge() >= 20
            && student.getSex() == 'm');
  }

  public List<Student> printStudent(List<Student> students, Predicate<Student> p) {
    List<Student> studentList = new ArrayList<>();
    for (Student student : students) {
      if (p.test(student)) {
        studentList.add(student);
        System.out.println(student);
      }
    }
    return studentList;
  }
}
