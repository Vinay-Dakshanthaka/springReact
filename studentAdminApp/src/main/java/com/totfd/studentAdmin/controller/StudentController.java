package com.totfd.studentAdmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.totfd.studentAdmin.dto.ResponseStructure;
import com.totfd.studentAdmin.dto.Student;
import com.totfd.studentAdmin.service.StudentService;

@RestController
@CrossOrigin
public class StudentController {
	
	@Autowired
	public StudentService studentService;
	
	@PostMapping("/students")
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student s){
		return studentService.saveStudent(s);
	}
	
	@PutMapping("/students/{studentId}")
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestBody Student s,@PathVariable long studentId){
		return studentService.updateStudent(s,studentId);
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<ResponseStructure<Student>> findById(@PathVariable long id){
		return studentService.findStudentById(id);
	}
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteStudent(@PathVariable long id){
		return studentService.deleteStudent(id);
	}
	
	@GetMapping("/students")
	public ResponseEntity<ResponseStructure<List<Student>>> getallStudents(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/search")
	public ResponseEntity<ResponseStructure<List<Student>>> searchStudentsByName(@RequestParam String keyword){
		return studentService.searchStudentByName(keyword);
	}
}
