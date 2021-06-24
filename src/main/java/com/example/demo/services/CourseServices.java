package com.example.demo.services;

import com.example.demo.dao.ICourseRepo;
import com.example.demo.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServices {
	private  ICourseRepo courseRepo;

	@Autowired
	public CourseServices(ICourseRepo courseRepo) {
		this.courseRepo = courseRepo;
	}

	public Course addCourse(Course learner){
		return courseRepo.save(learner);
	}

	public List<Course> findAllCourses(){
		return courseRepo.findAll();
	}

	//	@Transactional
	public Course updateCourse(Course learner){
		return  courseRepo.save(learner);
	}
	public void deleteCourse(Long cId){
		courseRepo.deleteById(cId);
	}


	public Course findById(Long cId) { return courseRepo.findBycId(cId);
	}

}
