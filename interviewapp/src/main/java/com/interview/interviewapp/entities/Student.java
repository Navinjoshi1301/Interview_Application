package com.interview.interviewapp.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Students")
public class Student {

   
    private int studentId;
    private String studentName;
    private String studentClass;
    private String studentLevel;

public Student(){
    
}

public Student(int studentId, String studentName, String studentClass, String studentLevel) {
    this.studentId = studentId;
    this.studentName = studentName;
    this.studentClass = studentClass;
    this.studentLevel = studentLevel;
}

 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="student_id")
public int getStudentId() {
    return studentId;
}

public void setStudentId(int studentId) {
    this.studentId = studentId;
}
@Basic
@Column(name="student_name")
public String getStudentName() {
    return studentName;
}

public void setStudentName(String studentName) {
    this.studentName = studentName;
}
@Basic
@Column(name="student_class")
public String getStudentClass() {
    return studentClass;
}

public void setStudentClass(String studentClass) {
    this.studentClass = studentClass;
}
@Basic
@Column(name="student_level")
public String getStudentLevel() {
    return studentLevel;
}

public void setStudentLevel(String studentLevel) {
    this.studentLevel = studentLevel;
}
}
