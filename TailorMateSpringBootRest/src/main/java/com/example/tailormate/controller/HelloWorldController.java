package com.example.tailormate.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping({ "/status" })
	public String firstPage() {
		return "Api running on Fire - Developed By Rimmel Asghar";
	}

}