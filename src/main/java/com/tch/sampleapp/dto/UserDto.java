package com.tch.sampleapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {

	@JsonProperty("firstname")
	private String name;
	
	private String model;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
}
