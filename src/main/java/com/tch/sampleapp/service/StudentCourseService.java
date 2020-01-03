package com.tch.sampleapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tch.sampleapp.dao.CourseRepo;
import com.tch.sampleapp.dao.StudentRepo;
import com.tch.sampleapp.model.Course;
import com.tch.sampleapp.model.Student;

@Service
public class StudentCourseService {

	@Autowired
	StudentRepo studentRepo;
	
	@Autowired
	CourseRepo courseRepo;
	

	public Student createStudent(Student student) {
	
/*		addressRepo.save(user.getAddress());
		UserInfo userInfo = userRepo.save(user);
		return userInfo;
	*/
		Student std = studentRepo.save(student);
		return std;
	}


	public Course createCourse(Course course) {
		// TODO Auto-generated method stub
		Course courseObj = courseRepo.save(course);
		return courseObj;
	}

/*	public List<UserInfo> getNames(String name) {
		return userRepo.findByName(name);
	
	}

	public UserInfo findById(String id) {
		Optional<UserInfo> userOpt = userRepo.findById(Long.parseLong(id));
		
		if(userOpt.isPresent())
			return userOpt.get();
		
		return null;
	}

	public List<UserInfo> getAll() {
		return userRepo.findAll();
	}

	public UserInfo updateUser(UserInfo userInfo, String id) {
		Optional<UserInfo> userOptional = userRepo.findById(Long.parseLong(id));
		
		if(userOptional.isPresent()) {
			userOptional.get().setName(userInfo.getName());
			userOptional.get().setAge(userInfo.getAge());
			
			return userRepo.save(userOptional.get());
		}
		return null;
	}

	public void deleteUser(String id) {
		userRepo.deleteById(Long.parseLong(id));
	}

	public List<UserInfo> findByNameAndAge(String name, String age) {	
		
		return userRepo.findByNameAndAge(name.toLowerCase(), Integer.parseInt(age));
	}*/
	
	
}
