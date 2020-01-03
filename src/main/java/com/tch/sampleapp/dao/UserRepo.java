package com.tch.sampleapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tch.sampleapp.model.UserInfo;
import java.lang.String;
import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserInfo, Long>{
	
	List<UserInfo> findByName(String name);
	
	@Query("SELECT u FROM UserInfo u where lower(u.name) = :name AND u.age = :age")
    public List<UserInfo> findByNameAndAge(@Param("name") String name, 
                                                    @Param("age") int age);
	
	
	@Query("SELECT a FROM UserInfo u, Address a where a.pincode = :pincode")
    public List<UserInfo> findByPincode(@Param("pincode") String pincode);
	//
}
