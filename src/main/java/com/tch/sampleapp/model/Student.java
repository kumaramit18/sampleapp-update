package com.tch.sampleapp.model;

import java.util.Set;
import java.sql.Timestamp;
import java.util.HashSet;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.JoinColumn;


@Entity
@Table(name = "STUDENT")
@Cacheable
public class Student {
	
	@Column(name="STUDENT_NAME", nullable=false)
	private String studentName;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "STUDENT_ID")
	private long studentId;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "STUDENT_COURSE", joinColumns = { @JoinColumn(name = "STUDENT_ID") }, inverseJoinColumns = { @JoinColumn(name = "COURSE_ID") })
	private Set <Course> courses = new HashSet<Course>(0);
	
	@CreationTimestamp
	private Timestamp onCreate;
	
	@UpdateTimestamp
	private Timestamp onUpdate;

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
	
	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	
	public Student() {
	}
	
	public Student(String studentName) {
		this.studentName = studentName;
	}

	public Student(String studentName, Set <Course> courses) {
		this.studentName = studentName;
		this.courses = courses;
	}
	

}
