package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.services.CourseServices;
import com.example.demo.services.StudentServices;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Slf4j
@Controller
@RequestMapping(value="/Student")
public class MainController {
	@Autowired
	private StudentServices studentservice;

	@Autowired
	private CourseServices courseServices;

	// creates student object that can remeber what was entered for sessions
	@ModelAttribute("studentObject")
	public String studentObject() {
		return "";
	}

	//course
	@ModelAttribute("courseObject")
	public String courseObject(){return ""; }

	@GetMapping("all")
	public String allstudents(Model model) {
		model.addAttribute("learners", studentservice.findAllStudents());
		return "allLearners";
	}


	@GetMapping("/add")
	public String addStudent(Model model){
		Student temp = new Student();
		model.addAttribute("learner", temp);
		return "LearnerAdd";
	}

	@GetMapping("/{id}")
	public String allstudentByID(@PathVariable("id") Long id, Model model) {

		Student found = studentservice.findById(id);
		model.addAttribute("learner", found);
		log.info("in profile "+ found.getName());
		return "learnerShow";
	}

	@GetMapping("/update/{id}")
	public String updateProfile(Model model, @PathVariable Long id){
		Student found = studentservice.findById(id);
		model.addAttribute("learner", found);
		log.info(found.getName());
		return "learnerUpdate";
	}

	@PostMapping("/save")
	public String saveUpdate(@ModelAttribute("learner") @Valid Student student,
	                         BindingResult result, Model model)
	{
		studentservice.updateStudent(student);

		model.addAttribute("learners", studentservice.findAllStudents());
		return "allLearners";

	}
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Long id, Model model){

		studentservice.deleteStudent(id);
		model.addAttribute("learners", studentservice.findAllStudents());
		return "allLearners";
	}

//	----------------end student start corse---------------------------



}
