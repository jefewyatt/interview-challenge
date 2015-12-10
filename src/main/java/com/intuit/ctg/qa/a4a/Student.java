package com.intuit.ctg.qa.a4a;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Student {
    
    private String name;
    private Date birthdate;
    private double gpa;
    private static ArrayList<String> courses;
    
    public Student(String name, Date date, Double gpa) {
        this.name = name;
        this.birthdate = date;
        this.gpa = gpa;
    }
    
    public void addCourse(String courseName) {
        courses.add(courseName);
    }
    
    public boolean hasCourse(String courseName) {
        return courses.contains(courseName);
    }
    
    public String getName() {
        return name;
    }
    
    public String getLastNameFirst() {
        String[] names = name.split(" ");
        return names[1] + ", " + names[0];
    }
    
    public boolean isBirthday(Date today) {
        Calendar now = Calendar.getInstance();
        now.setTime(today);
        Calendar dob = Calendar.getInstance();
        dob.setTime(birthdate);
        
        return now.get(Calendar.DAY_OF_YEAR) == dob.get(Calendar.DAY_OF_YEAR);
    }
    
    public Student getBetterStudent(Student otherStudent) {
        if (this.gpa > otherStudent.gpa) {
            return this;
        }
        return otherStudent;
    }
    
    @Override
    public boolean equals(Object other) {
        Student otherStudent = (Student)other;
        
        if (!this.name.equals(otherStudent.name)) return false;
        if (!(this.birthdate == otherStudent.birthdate)) return false; 
        if (!(this.gpa == otherStudent.gpa)) return false;
        
        return true;
    }
}
