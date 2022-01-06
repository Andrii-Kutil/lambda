package com.gmail.kutilandrej;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;

class StudentInfoTest {

  @Test
  void testPrintStudentEmptyList() {
    StudentInfo studentInfo = new StudentInfo();
    assertTrue(
        studentInfo.printStudent(new ArrayList<>(), (Predicate<Student>) mock(Predicate.class))
            .isEmpty());
  }

  @Test
  void testPrintStudent2() {
    StudentInfo studentInfo = new StudentInfo();

    ArrayList<Student> studentList = new ArrayList<>();
    studentList.add(new Student("Name", 'A', 1, 1, 10.0));
    Predicate<Student> predicate = (Predicate<Student>) mock(Predicate.class);
    when(predicate.test(any())).thenReturn(true);
    assertEquals(1, studentInfo.printStudent(studentList, predicate).size());
    verify(predicate).test(any());
  }

  @Test
  void testPrintStudent3() {
    StudentInfo studentInfo = new StudentInfo();

    ArrayList<Student> studentList = new ArrayList<>();
    studentList.add(new Student("Name", 'A', 1, 1, 10.0));
    Predicate<Student> predicate = (Predicate<Student>) mock(Predicate.class);
    when(predicate.test((Student) any())).thenReturn(false);
    assertTrue(studentInfo.printStudent(studentList, predicate).isEmpty());
    verify(predicate).test((Student) any());
  }
}

