package com.example.demo;

import com.example.demo.dao.IStudentRepo;
import com.example.demo.models.Student;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
@Log
@Transactional
public class startupConfig implements CommandLineRunner {
	IStudentRepo studentRepo;


	@Autowired
	public startupConfig(IStudentRepo studentRepo) {
		this.studentRepo = studentRepo;
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("**** Start adding Learners sql statements ****");
		studentRepo.save(new Student(1L, "bob","thisEmail@gmail.com" ));
		studentRepo.save(new Student(2L, "Tom","thisEmailTom@gmail.com" ));
		studentRepo.save(new Student(3L, "work","thisAEmail@gmail.com" ));
	}
	@PostConstruct
	public void constructed(){
		log.warning("StartupRunner Constructed!");
	}
}
