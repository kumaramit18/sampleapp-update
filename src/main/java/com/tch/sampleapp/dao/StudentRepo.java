package com.tch.sampleapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tch.sampleapp.model.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

	
}
