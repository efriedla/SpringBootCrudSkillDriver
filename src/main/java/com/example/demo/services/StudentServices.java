package com.example.demo.services;

import com.example.demo.dao.IStudentRepo;
import com.example.demo.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServices {
	private IStudentRepo studentdao;

	@Autowired
	public StudentServices(IStudentRepo studentdao) {
		this.studentdao = studentdao;
	}


	public Student addStudent(Student learner){
		return studentdao.save(learner);
	}

	public List<Student> findAllStudents(){
		return studentdao.findAll();
	}

//	@Transactional
	public Student updateStudent(Student learner){
		return  studentdao.save(learner);
	}
	public void deleteStudent(Long id){
		studentdao.deleteById(id);
	}


	public Student findById(Long id) { return studentdao.findByid(id);
	}
}
