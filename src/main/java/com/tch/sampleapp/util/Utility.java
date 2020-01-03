package com.tch.sampleapp.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Utility {

	@Scheduled(fixedDelay=2000)
	public void fun() {
		System.out.println("OKOK");
	}
}
