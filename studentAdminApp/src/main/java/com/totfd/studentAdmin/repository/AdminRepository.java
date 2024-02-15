//package com.totfd.studentAdmin.repository;
//
//import java.util.Optional;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import com.totfd.studentAdmin.dto.Admin;
//
//public interface AdminRepository extends JpaRepository<Admin, Long> {
//
//	@Query("select a from Admin a where a.email=?1 and a.password=?2")
//	Optional<Admin> verifyAdmin(String email, String password);
//
//}
