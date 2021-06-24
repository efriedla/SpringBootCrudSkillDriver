package com.example.demo.controllers;

import com.example.demo.models.Course;
import com.example.demo.models.Course;
import com.example.demo.services.CourseServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping(value="/Course")
public class CourseController {
	@Autowired
	private CourseServices courseServices;
	@ModelAttribute("courseObject")
	public String courseObject(){return ""; }

	@GetMapping("/all")
	public String allcourses(Model model) {
	model.addAttribute("courses", courseServices.findAllCourses());
	return "allCourses";
}


	@GetMapping("/add")
	public String addCourse(Model model){
		Course temp = new Course();
		model.addAttribute("course", temp);
		return "CourseAdd";
	}

	@GetMapping("/{cId}")
	public String allcourseByID(@PathVariable("cId") Long cId, Model model) {

		Course found = courseServices.findById(cId);
		model.addAttribute("course", found);
		log.info("in course profile "+ found.getCName());
		return "courseShow";
	}

	@GetMapping("/update/{cId}")
	public String updateCourse(Model model, @PathVariable Long cId){
		Course found = courseServices.findById(cId);
		model.addAttribute("course", found);
		log.info(found.getCName());
		return "courseUpdate";
	}
//
	@PostMapping("/save")
	public String saveUpdate(@ModelAttribute("course") @Valid Course course,
	                         BindingResult result, Model model) {
		courseServices.updateCourse(course);

		model.addAttribute("courses", courseServices.findAllCourses());
		return "allCourses";
	}
	@GetMapping("/delete/{cId}")
	public String deleteCourse(@PathVariable Long cId, Model model){

		courseServices.deleteCourse(cId);
		model.addAttribute("courses", courseServices.findAllCourses());
		return "allCourses";
	}
}
