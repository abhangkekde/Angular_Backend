package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Student;
import com.app.service.IStudentService;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
	@Autowired
	IStudentService service;

	@GetMapping
	public ResponseEntity<?> getAllStudents() {
		System.out.println("In getAllStudents of " + getClass().getName());
		// invoking service layer method to get students
		List<Student> students = service.getAllStudents();
		if (students.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(students,HttpStatus.OK);
	}
	
	@GetMapping("/{sId}")
	public ResponseEntity<?> getStudentById(@PathVariable int sId) {
		System.out.println("In getStudentById of " + getClass().getName());
		Optional<Student> student = service.getStudentDetailsById(sId);
		if (!student.isPresent())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(student,HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> saveStudent(@RequestBody Student s) {
		System.out.println("In saveStudent of " + getClass().getName());
		try {
			Student student = service.saveStudent(s);
			return new ResponseEntity<>(student, HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
