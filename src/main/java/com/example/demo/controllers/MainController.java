package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.services.StudentServices;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Log
@Controller
@RequestMapping(value="/Student")
public class MainController {
	@Autowired
	private StudentServices studentservice;

	// creates student object that can remeber what was entered for sessions
	@ModelAttribute("studentObject")
	public String studentObject() {
		return "";
	}

//	@PostMapping("save-student")
//	public boolean saveStudent(@RequestBody Student student) {
//		return studentservice.saveStudent(student);
//	}

	@GetMapping("all")
	public String allstudents(Model model) {
		model.addAttribute("learners", studentservice.findAllStudents());
		return "allLearners";
	}

//	@DeleteMapping("delete-student/{student_id}")
//	public boolean deleteStudent(@PathVariable("student_id") int student_id,Student student) {
//		student.setStudent_id(student_id);
//		return studentservice.deleteStudent(student);
//	}

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
//			, @RequestParam("id") Long id)
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

//	@PostMapping("update-student/{student_id}")
//	public boolean updateStudent(@RequestBody Student student,@PathVariable("student_id") int student_id) {
//		student.setStudent_id(student_id);
//		return studentservice.updateStudent(student);
//	}
}
