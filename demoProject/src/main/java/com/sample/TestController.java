package com.sample;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "rest"	)
public class TestController {
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void testMsg() {
		System.out.println("Hello world");
	}
}
