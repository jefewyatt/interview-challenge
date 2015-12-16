package com.intuit.ctg.qa.a4a;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * INSTRUCTIONS
 * Please write unit tests for this class in StudentTest.java
 * 
 * Comment on and fix any issues your unit tests find in Student.java
 */
public class Student {
    
    private String name;
    private Date birthdate;
    private double gpa;
    private static ArrayList<String> courses;
    
    /**
     * Instantiates a Student object
     */
    public Student(String name, Date date, Double gpa) {
        this.name = name;
        this.birthdate = date;
        this.gpa = gpa;
    }
    
    /**
     * Adds a course to the student's list of courses
     */
    public void addCourse(String courseName) {
        courses.add(courseName);
    }
    
    /**
     * Returns true if a student is taking a course, false otherwise
     */
    public boolean hasCourse(String courseName) {
        return courses.contains(courseName);
    }
    
    /* Returns the students name */
    public String getName() {
        return name;
    }
    
    /* Returns the student's name with the last name, followed by the first name.
     * For example: "John Smith" should return "Smith, John"
     */
    public String getLastNameFirst() {
        String[] names = name.split(" ");
        return names[1] + ", " + names[0];
    }
    
    /* Returns true if today is student's birthday, false otherwise */
    public boolean isBirthday() {
        Calendar now = Calendar.getInstance();
        Calendar dob = Calendar.getInstance();
        dob.setTime(birthdate);
        
        return now.get(Calendar.DAY_OF_YEAR) == dob.get(Calendar.DAY_OF_YEAR);
    }
    
    /* Returns a student object representing the student with a higher GPA */
    public Student getBetterStudent(Student otherStudent) {
        if (this.gpa > otherStudent.gpa) {
            return this;
        }
        return otherStudent;
    }
    
    /* Returns true if the the student has the same name, birthday, and GPA as this student. False otherwise */
    @Override
    public boolean equals(Object other) {
        Student otherStudent = (Student)other;
        
        if (!this.name.equals(otherStudent.name)) return false;
        if (!(this.birthdate == otherStudent.birthdate)) return false; 
        if (!(this.gpa == otherStudent.gpa)) return false;
        
        return true;
    }
}
