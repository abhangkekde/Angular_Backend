package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.StudentRepository;
import com.app.pojos.Student;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {
	@Autowired
	StudentRepository repo;

	@Override
	public List<Student> getAllStudents() {
		// JPA Repository findAll
		return repo.findAll();
	}

	@Override
	public Optional<Student> getStudentDetailsById(int id) {
		// Fetch StudentDetailsById
		return repo.findById(id);
	}

	@Override
	public Student saveStudent(Student transientStudent) {
		Student student = repo.save(transientStudent);
		return student;
	}

}
