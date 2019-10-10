package com.firstboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestFile {
	@RequestMapping("/testing")
	public String test() {
		return "test successful server is working";
	}
}
