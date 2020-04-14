package com.firstboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestFile {
	
	@RequestMapping("/test")
	public String test() {
		return "test successful server is working";
	}
	
	@RequestMapping("/")
	public String welcome() {
		return "welcome to spring boot";
	}
}
