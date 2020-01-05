package com.tch.sampleapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tch.sampleapp.dao.AddressRepo;
import com.tch.sampleapp.dao.UserRepo;
import com.tch.sampleapp.exception.StudentException;
import com.tch.sampleapp.model.UserInfo;

@Service
public class SampleService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	AddressRepo addressRepo;
	

	public UserInfo save(UserInfo user) {
		/*Optional<UserInfo> userInfoOpt = userRepo.findById(1L); 
		
		userInfoOpt.of*/

		addressRepo.save(user.getAddress());
		UserInfo userInfo = userRepo.save(user);
		return userInfo;
		
	}

	//@Cacheable(value = "userinfo.getname", key = "#name")
	public List<UserInfo> getNames(String name) {
		return userRepo.findByName(name);
	
	}

	public UserInfo findById(String id) {
		Optional<UserInfo> userOpt = userRepo.findById(Long.parseLong(id));
		
		if(userOpt.isPresent())
			return userOpt.get();
		
		throw new StudentException("The student is unavailable ::"+ id);
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
	}
	
}
