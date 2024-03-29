package com.interview.interviewapp.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.interviewapp.dao.StudentRepository;
import com.interview.interviewapp.entities.Student;

@Service
@SuppressWarnings("null")
public class StudentServices {

    @Autowired
    private StudentRepository studentRepository;

    // add student

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    // addstudents

    public List<Student> addStudents(List<Student> students) {
        return studentRepository.saveAll(students);
    }

    // get student by id

    public Student getStudentbyId(int id) {
        Student student2 = null;
        try {
            Optional<Student> student = studentRepository.findById(id);
            student2 = student.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student2;

    }

    // get Students
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    // delete student
    public Student deleteStudentById(int id) {
        Optional<Student> studentOptional = studentRepository.findById(id);

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            studentRepository.deleteById(id);
            return student;
        } else {
            throw new NoSuchElementException("Student with ID " + id + " not found");
        }
    }

    // update student
    public Student updateLevel(Student student, int id) {
        Optional<Student> students = studentRepository.findById(id);
        Student student1 = students.get();
        student1.setStudentLevel(student.getStudentLevel());
        studentRepository.save(student1);
        return student1;

    }

}