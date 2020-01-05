package com.tch.sampleapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tch.sampleapp.dto.UserDto;
import com.tch.sampleapp.model.Student;
import com.tch.sampleapp.model.UserInfo;
import com.tch.sampleapp.service.SampleService;
import com.tch.sampleapp.service.StudentCourseService;

@RestController
@RequestMapping("/user")
public class SampleController {

	Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	
	@Value(value = "${com.tch.custom}")
	private String property;
	
	@Autowired
	SampleService sampleService;
	
	@Autowired
	StudentCourseService studentCourseService;
	
	
/*	@GetMapping({"/get/{id}/{firstname}", "/{id}"})
	public String firstService(@PathVariable String id, @PathVariable(required=false) String firstname) {
		
		System.out.println("ID:: "+id+" Name:: "+firstname);
		return id+" "+firstname;
	}*/
	
	
	@PostMapping("/save")
	public UserInfo save(@RequestBody UserInfo user) {
		return sampleService.save(user);
	}
	
	@GetMapping("/find/id/{id}")
	public UserInfo findById(@PathVariable String id){
		return sampleService.findById(id);
	}
	
	@GetMapping("/getusers")
	public List<UserInfo> getAllUser(){
		return sampleService.getAll();
	}
	
	@GetMapping("/find/name/{name}")
	public List<UserInfo> nameList(@PathVariable String name){
		return sampleService.getNames(name);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<UserInfo> updateUser(@RequestBody UserInfo userInfo, @PathVariable String id) {
		return new ResponseEntity<UserInfo>(sampleService.updateUser(userInfo,id),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable String id) {
		sampleService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@GetMapping("/get/{id}")
	public UserDto getCustomUser(@PathVariable String id) {
		UserInfo user = sampleService.findById(id);
		UserDto userDto = new UserDto();
		
		logger.info("get called toget customer, Property Name:: "+property);
		
		userDto.setName(user.getName());
		userDto.setModel(user.getAge()+"");
		return userDto;
	}
	
	@GetMapping("/geByNameAndAge/")
	public List<UserInfo> geByNameAndAge(@RequestParam("name") String name, @RequestParam("age") String age) {
		
		List<UserInfo> userInfoList = sampleService.findByNameAndAge(name, age);
		return userInfoList;
	}
	
	@PostMapping("/createStudent")
	public Student createStudent(@RequestBody Student student) {
		return studentCourseService.createStudent(student);
	}
	
}
