package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Student;

public interface IStudentService {
	// List all students
	List<Student> getAllStudents();

	// get student details by id
	Optional<Student> getStudentDetailsById(int id);

	// add student
	Student saveStudent(Student transientStudent);
}
