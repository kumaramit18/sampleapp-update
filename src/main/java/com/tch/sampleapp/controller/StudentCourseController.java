package com.tch.sampleapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tch.sampleapp.model.Course;
import com.tch.sampleapp.model.Student;
import com.tch.sampleapp.service.StudentCourseService;

@RestController
@RequestMapping("/")
public class StudentCourseController {

	@Autowired
	StudentCourseService studentCourseService;
	
/*		
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
	public UserInfo updateUser(@RequestBody UserInfo userInfo, @PathVariable String id) {
		return sampleService.updateUser(userInfo,id);
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
		
		userDto.setName(user.getName());
		userDto.setModel(user.getAge()+"");
		return userDto;
	}
	
	@GetMapping("/geByNameAndAge/")
	public List<UserInfo> geByNameAndAge(@RequestParam("name") String name, @RequestParam("age") String age) {
		
		List<UserInfo> userInfoList = sampleService.findByNameAndAge(name, age);
		return userInfoList;
	} */
	
	@PostMapping("/createStudent")
	public Student createStudent(@RequestBody Student student) {
		return studentCourseService.createStudent(student);
	}
	
	@PostMapping("/createCourse")
	public Course createCourse(@RequestBody Course course) {
		return studentCourseService.createCourse(course);
	}

}
