package com.tch.sampleapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class StudentAspect {
	 private Logger logger = LoggerFactory.getLogger(this.getClass());

	 
	  @Before("execution(* com.tch.sampleapp.service.StudentCourseService.*(..))")
	  public void before(JoinPoint joinPoint) {
	        //Advice
	        logger.info(" Check for user access ");
	        logger.info(" Allowed execution for {}", joinPoint);
	  }
	  
	  @After("execution(* com.tch.sampleapp.service.StudentCourseService.*(..))")
	  public void after(JoinPoint joinPoint) {
	        //Advice
	        logger.info(" After Check for user access ");
	        logger.info(" After Allowed execution for {}", joinPoint);
	  }
	    
}
