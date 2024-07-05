package com.example.util;

public class InputValidator {

    public static boolean validateName(String name) {
        // Implement name validation logic
          name = name.toLowerCase();
        return name != null && !name.trim().isEmpty();
    }

    public static boolean validateGrade(double grade)  {
        // Implement grade validation logic
        return grade >= Constants.MIN_GRADE && grade <= Constants.MAX_GRADE;
    }
}
