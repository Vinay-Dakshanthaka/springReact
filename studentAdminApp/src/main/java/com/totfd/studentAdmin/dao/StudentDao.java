package com.totfd.studentAdmin.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.totfd.studentAdmin.dto.Student;
import com.totfd.studentAdmin.repository.StudentRepository;

@Repository
public class StudentDao {

	@Autowired
	StudentRepository repository;
	
	public Student saveStudent(Student student) {
		return repository.save(student);
	}
	
	public Student updateStudent(Student student) {
		return repository.save(student);
	}
	
	public Optional<Student> findStudentById(long sid){
		return repository.findById(sid);
	}
	
	public void deleteStudent(long id) {
		repository.deleteById(id);
	}
	
	public List<Student> getAllStudents(){
		return repository.findAll();
	}
	
	public List<Student> searchStudentByname(String keyword){
		return repository.findByFirstNameContaining(keyword);
	}
	
//	public Optional<Student> verifyStudent(String email,String password){
//		return repository.verifyStudent(email, password);
//	}
}
