package com.example.demo.controllers;

import com.example.demo.services.CourseServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value="/Course")
public class CourseController {
	@Autowired
	private CourseServices courseServices;
	@ModelAttribute("courseObject")
	public String courseObject(){return ""; }

	@GetMapping("/all")
	public String allstudents(Model model) {
	model.addAttribute("courses", courseServices.findAllCourses());
	return "allCourses";
}


//	@GetMapping("/add")
//	public String addStudent(Model model){
//		Student temp = new Student();
//		model.addAttribute("learner", temp);
//		return "LearnerAdd";
//	}
//
//	@GetMapping("/{id}")
//	public String allstudentByID(@PathVariable("id") Long id, Model model) {
//
//		Student found = studentservice.findById(id);
//		model.addAttribute("learner", found);
//		log.info("in profile "+ found.getName());
//		return "learnerShow";
//	}

//	@GetMapping("/update/{id}")
//	public String updateProfile(Model model, @PathVariable Long id){
//		Student found = studentservice.findById(id);
//		model.addAttribute("learner", found);
//		log.info(found.getName());
//		return "learnerUpdate";
//	}
//
//	@PostMapping("/save")
//	public String saveUpdate(@ModelAttribute("learner") @Valid Student student,
//	                         BindingResult result, Model model)
//	{
//		studentservice.updateStudent(student);
//
//		model.addAttribute("learners", studentservice.findAllStudents());
//		return "allLearners";
//
//	}
//	@GetMapping("/delete/{id}")
//	public String deleteStudent(@PathVariable Long id, Model model){
//
//		studentservice.deleteStudent(id);
//		model.addAttribute("learners", studentservice.findAllStudents());
//		return "allLearners";
//	}
}
