package com.example.demo;

import com.example.demo.dao.ICourseRepo;
import com.example.demo.dao.IStudentRepo;
import com.example.demo.models.Course;
import com.example.demo.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
@Slf4j
@Transactional
public class startupConfig implements CommandLineRunner {
	IStudentRepo studentRepo;
	ICourseRepo courseRepo;



	@Autowired
	public startupConfig(IStudentRepo studentRepo, ICourseRepo courseRepo) {
		this.studentRepo = studentRepo;
		this.courseRepo = courseRepo;
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("**** Start adding Learners sql statements ****");
		studentRepo.save(new Student(1L, "bob","thisEmail@gmail.com","pass1" ));
		studentRepo.save(new Student(2L, "Tom","thisEmailTom@gmail.com","pass2"  ));
		studentRepo.save(new Student(3L, "work","thisAEmail@gmail.com","pass3"  ));
		log.info("****** start adding courses");
		courseRepo.save((new Course(1L,"Java", "Development")));
		courseRepo.save((new Course(2L,"Spring-Boot", "Development Java web")));

	}
	@PostConstruct
	public void constructed(){
		log.warn("StartupRunner Constructed!");
	}
}
