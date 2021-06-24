package com.example.demo.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="student")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	Long id;
	String name;
	String email;
	String password;

	public Student(Long id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	@ManyToMany
	@JoinTable
			(
					name= "student_course",
					joinColumns=@JoinColumn(name = "id"),
					inverseJoinColumns=@JoinColumn( name = "cId")
			)
	@ToString.Exclude
	List<Course> courses;


}
