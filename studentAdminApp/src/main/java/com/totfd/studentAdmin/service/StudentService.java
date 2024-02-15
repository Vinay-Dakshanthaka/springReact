package com.totfd.studentAdmin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.totfd.studentAdmin.dao.StudentDao;
import com.totfd.studentAdmin.dto.ResponseStructure;
import com.totfd.studentAdmin.dto.Student;
import com.totfd.studentAdmin.exception.IdNotFoundException;
import com.totfd.studentAdmin.exception.InvalidCredentialsException;
import com.totfd.studentAdmin.exception.NoStudentFoundWithThisNameExcetion;

@Service
public class StudentService {
	
	@Autowired
	StudentDao studentDao;
	
	public ResponseEntity<ResponseStructure<Student>> saveStudent(Student student){
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		student = studentDao.saveStudent(student);
		structure.setData(student);
		structure.setCode(HttpStatus.CREATED.value());
		structure.setMessage("Student Data Saved Successfully");
		
		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.CREATED);
	}
	
	
	public ResponseEntity<ResponseStructure<Student>> updateStudent(Student student,long studentId){
		Optional<Student> recStudent = studentDao.findStudentById(studentId);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		if(recStudent.isPresent()) {
			studentDao.saveStudent(student);
			structure.setData(student);
			structure.setMessage("Student udated Successfully");
			structure.setCode(HttpStatus.CREATED.value());

			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Student>> findStudentById(long id){
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		Optional<Student> student = studentDao.findStudentById(id);
		if(student.isEmpty()) {
			throw new IdNotFoundException();
		}else {
			structure.setData(student.get());
			structure.setCode(HttpStatus.OK.value());
			structure.setMessage("Student with the "+id+" is Found");
		}
		return new  ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
	}
	
//	public ResponseEntity<ResponseStructure<Student>> verifyStudent(String email, String password){
//		ResponseStructure<Student> structure = new ResponseStructure<>();
//		Optional<Student> recStudent = studentDao.verifyStudent(email, password);
//		if(recStudent.isPresent()) {
//			structure.setData(recStudent.get());
//			structure.setMessage("Student Login Successfull");
//			structure.setCode(HttpStatus.OK.value());
//			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
//		}
//		throw new InvalidCredentialsException();
//	}
	
	public ResponseEntity<ResponseStructure<List<Student>>> getAllStudents(){
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		structure.setData(studentDao.getAllStudents());
		structure.setMessage("All Student List");
		structure.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Student>>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteStudent(long id){
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<Student> recStudent = studentDao.findStudentById(id);
		if(recStudent.isPresent()) {
			structure.setData("Student Found");
			structure.setMessage("Student Deleted");
			structure.setCode(HttpStatus.OK.value());
			studentDao.deleteStudent(id);
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		structure.setData("Studednt with the "+id+" not found");
		structure.setMessage("Student not Deleted");
		structure.setCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<ResponseStructure<List<Student>>> searchStudentByName(String keyword){
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		List<Student> students = studentDao.searchStudentByname(keyword);
		if(students.isEmpty()) {
			throw new NoStudentFoundWithThisNameExcetion();
		}else {
		structure.setData(studentDao.searchStudentByname(keyword));
		structure.setMessage("List of Students with the name " +keyword);
		structure.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.OK);
		}
	}
	
}
