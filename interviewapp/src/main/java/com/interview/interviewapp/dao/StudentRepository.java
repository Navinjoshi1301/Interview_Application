package com.interview.interviewapp.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interview.interviewapp.entities.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{

    Optional<Student>findById(int studentId);
    
    
}