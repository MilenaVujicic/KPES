package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.service.DeloService;

@RestController
@RequestMapping(value = "rest")
public class TestController {
	
	@Autowired
	DeloService deloService;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void testMsg() {
		if(deloService == null) {
			System.out.println("It is null");
		}
		else {
			System.out.println("It is not null");
		}
		System.out.println("Hello world");
	}
}
