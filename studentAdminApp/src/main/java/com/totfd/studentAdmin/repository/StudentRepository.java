package com.totfd.studentAdmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.totfd.studentAdmin.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
//	@Query("select s from Student s where s.email=?1 and s.password=?2")
//	Optional<Student> verifyStudent(String email, String password);
	
	List<Student> findByFirstNameContaining(String keyword);

}
