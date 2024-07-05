package com.example.util;

import com.example.model.Student;

import java.util.List;

public class GradeCalculator {

    public static double calculateAverage(List<Student> students) {
        if (students == null || students.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (Student student : students) {
            sum += student.getGrade();
        }
        return Math.round(sum / students.size() * Math.pow(10, Constants.GRADE_SCALE)) / Math.pow(10, Constants.GRADE_SCALE);
    }

    public static double findHighestGrade(List<Student> students) {
        double highest = Constants.MIN_GRADE;
        for (Student student : students) {
            if (student.getGrade() > highest) {
                highest = student.getGrade();
            }
        }
        return highest;
    }

    public static double findLowestGrade(List<Student> students) {
        double lowest = Constants.MAX_GRADE;
        for (Student student : students) {
            if (student.getGrade() < lowest) {
                lowest = student.getGrade();
            }
        }
        return lowest;
    }
}
