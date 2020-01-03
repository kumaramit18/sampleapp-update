package com.tch.sampleapp.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="COURSE")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COURSE_ID")
	private long courseId;
	
	@Column(name="COURSE_NAME", nullable=false)
	private String courseName;

	@UpdateTimestamp
	private Timestamp onUpdate;
	
	@CreationTimestamp
	private Timestamp onCreate;
	
	public long getCourseId() {
		return this.courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public Timestamp getOnUpdate() {
		return onUpdate;
	}

	public void setOnUpdate(Timestamp onUpdate) {
		this.onUpdate = onUpdate;
	}

	public Timestamp getOnCreate() {
		return onCreate;
	}

	public void setOnCreate(Timestamp onCreate) {
		this.onCreate = onCreate;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}