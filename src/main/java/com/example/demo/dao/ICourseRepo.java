package com.example.demo.dao;

import com.example.demo.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepo extends JpaRepository<Course, Long> {
	Course findBycId(Long cId);



}
