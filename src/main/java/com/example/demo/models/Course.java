package com.example.demo.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="course")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	Long cId;
	String cName;
	String cUsedFor;

	public Course(Long cId, String cName, String cUsedFor) {
		this.cId = cId;
		this.cName = cName;
		this.cUsedFor = cUsedFor;
	}

	//joining students
	@ManyToMany(mappedBy = "courses")
	List<Student> students;


}
