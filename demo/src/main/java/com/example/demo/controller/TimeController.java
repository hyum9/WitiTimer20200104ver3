package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController {
	
	@RequestMapping("/stopwatch")
	public String index() {
		return "/demo";
	}

}
