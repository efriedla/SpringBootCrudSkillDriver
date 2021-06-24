package com.example.demo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HomeController {
	@GetMapping({"/","index"})
	public String index() {
		return "home";
	}
	@GetMapping("/404")
	public String error(){
		return "error";
	}
	@GetMapping("/login")
	public String login(){
		return "Login";
	}
}
