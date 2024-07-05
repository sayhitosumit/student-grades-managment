package com.example;

import com.example.model.Student;
import com.example.service.StudentService;
import com.example.util.GradeCalculator;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.jupiter.api.BeforeEach;

import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    private StudentService studentService;

    @BeforeEach
    public void setUp() {
        studentService = new StudentService();
    }

    @Test
    public void testAddStudent() {
        String name = "John Doe";
        double grade = 85.5;

        boolean result = studentService.addStudent(name, grade);

        assertTrue("The student should be added successfully.", result);

        Map<Integer, Student> students = studentService.listStudents();
        assertEquals(1, students.size(), "There should be one student in the list.");

        Student student = students.values().iterator().next();
        assertEquals(name, student.getName(), "The student's name should match.");
        assertEquals(grade, student.getGrade(), "The student's grade should match.");
    }

    @Test
    public void testCalculateAverageGrade() {
        studentService.addStudent("Alice", 90.0);
        studentService.addStudent("Bob", 80.0);
        studentService.addStudent("Charlie", 70.0);

        double average = GradeCalculator.calculateAverage(studentService.listStudents().values().stream().toList());
        assertEquals(80.0, average, 0.01, "The average grade should be calculated correctly.");
    }

    @Test
    public void testFindHighestGrade() {
        studentService.addStudent("Alice", 90.0);
        studentService.addStudent("Bob", 80.0);
        studentService.addStudent("Charlie", 70.0);

        double highest = GradeCalculator.findHighestGrade(studentService.listStudents().values().stream().toList());
        assertEquals(90.0, highest, "The highest grade should be found correctly.");
    }

    @Test
    public void testFindLowestGrade() {
        studentService.addStudent("Alice", 90.0);
        studentService.addStudent("Bob", 80.0);
        studentService.addStudent("Charlie", 70.0);

        double lowest = GradeCalculator.findLowestGrade(studentService.listStudents().values().stream().toList());
        assertEquals(70.0, lowest, "The lowest grade should be found correctly.");
    }
}
