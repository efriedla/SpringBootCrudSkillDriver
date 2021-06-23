package com.example.demo.dao;

import com.example.demo.models.Student;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepo 
		extends
		JpaRepository<Student, Long>
{
//	public boolean saveStudent(Student student);
//	public List<Student> getStudents();
//	public boolean deleteStudent(Student student);
//	public List<Student> getStudentByID(Student student);
//	Student getStudentByID(int id);
//	public boolean updateStudent(Student student);
	Student findByid(Long id);

	void deleteById(Long id);

//	List<Student> findAll();
//
//	Student save(Student learner);
}
