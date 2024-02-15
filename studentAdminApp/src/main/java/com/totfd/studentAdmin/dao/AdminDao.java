//package com.totfd.studentAdmin.dao;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.totfd.studentAdmin.dto.Admin;
//import com.totfd.studentAdmin.repository.AdminRepository;
//
//@Repository
//public class AdminDao {
//	
//	@Autowired
//	AdminRepository repository;
//	
//	public Admin updateAdmin(Admin admin) {
//		return repository.save(admin);
//	}
//	
//	public Optional<Admin> verifyAdmin(String email,String password){
//		return repository.verifyAdmin(email, password);
//	}
//}
