package com.tch.sampleapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tch.sampleapp.model.Course;

public interface CourseRepo extends JpaRepository<Course, Long> {

}
