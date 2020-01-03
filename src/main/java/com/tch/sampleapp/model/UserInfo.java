package com.tch.sampleapp.model;

import java.sql.Timestamp;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "USER_INFO")
@Cacheable
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private int age;

	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;

	@UpdateTimestamp
	private Timestamp onUpdate;

	@CreationTimestamp
	private Timestamp onCreate;

	public Timestamp getOnUpdate() {
		return onUpdate;
	}

	// @PreUpdate
	public void setOnUpdate(Timestamp onUpdate) {
		this.onUpdate = onUpdate;
	}

	public Timestamp getOnCreate() {
		return onCreate;
	}

	// @PreUpdate
	public void setOnCreate(Timestamp onCreate) {
		this.onCreate = onCreate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
