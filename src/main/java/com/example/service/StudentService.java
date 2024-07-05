package com.example.service;

import com.example.model.Student;
import com.example.util.InputValidator;

import java.util.HashMap;
import java.util.Map;

public class StudentService {
    private final Map<Integer, Student> studentMap = new HashMap<>();
    private int nextId = 1;

    public boolean addStudent(String name, double grade) {
        if (InputValidator.validateName(name) && InputValidator.validateGrade(grade)) {
            Student student = new Student(nextId++, name, grade);
            studentMap.put(student.getId(), student);
            return true;
        }
        return false;
    }

    public boolean updateStudent(int id, String name, double grade) {
        if (studentMap.containsKey(id) && InputValidator.validateName(name) && InputValidator.validateGrade(grade)) {
            Student student = studentMap.get(id);
            student.setName(name);
            student.setGrade(grade);
            return true;
        }
        return false;
    }

    public boolean deleteStudent(int id) {
        return studentMap.remove(id) != null;
    }

    public Map<Integer, Student> listStudents() {
        return new HashMap<>(studentMap);
    }

    public double calculateAverage() {
        int numOfStudents =studentMap.size();
        if(numOfStudents==0) {
            return 0;
        }
        double totalGrade =0;
        for (Map.Entry<Integer, Student> set : studentMap.entrySet()){
            Student currentStudent = set.getValue();
            totalGrade = totalGrade+currentStudent.getGrade();
        }
        return totalGrade/numOfStudents;
    }

    public double getHighestGrade() {
        double highest=0;
        for (Map.Entry<Integer, Student> set : studentMap.entrySet()){
            Student currentStudent = set.getValue();
            if(currentStudent.getGrade()>highest){
                highest=currentStudent.getGrade();
            }
        }
        return highest;
    }

    public boolean searchStudent(String name) {
         int flag =0;
        for (Map.Entry<Integer, Student> set : studentMap.entrySet()){
            Student currentStudent = set.getValue();
            String studentName=currentStudent.getName();
            if(name.equals(studentName)) return true;

        }
        return false;
    }

}
