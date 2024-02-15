//package com.totfd.studentAdmin.service;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import com.totfd.studentAdmin.dao.AdminDao;
//import com.totfd.studentAdmin.dto.Admin;
//import com.totfd.studentAdmin.dto.ResponseStructure;
//import com.totfd.studentAdmin.exception.InvalidCredentialsException;
//
//@Service
//public class AdminService {
//	
//	@Autowired
//	AdminDao adminDao;
//	
//	
//	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin){
//		ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
//		admin = adminDao.updateAdmin(admin);
//		structure.setData(admin);
//		structure.setCode(HttpStatus.CREATED.value());
//		structure.setMessage("Student Data updated Successfully");
//		
//		return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.CREATED);
//	}
//	
//	public ResponseEntity<ResponseStructure<Admin>> verifyAdmin(String email, String password){
//		ResponseStructure<Admin> structure = new ResponseStructure<>();
//		Optional<Admin> recAdmin = adminDao.verifyAdmin(email, password);
//		if(recAdmin.isPresent()) {
//			structure.setData(recAdmin.get());
//			structure.setMessage("Admin Login Successfull");
//			structure.setCode(HttpStatus.OK.value());
//			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
//		}
//		throw new InvalidCredentialsException();
//	}
//}
