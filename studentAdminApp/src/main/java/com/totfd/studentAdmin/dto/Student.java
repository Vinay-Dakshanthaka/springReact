package com.totfd.studentAdmin.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId; 
    
//    //Generates custom ID 
//    public String getFormattedId() {
//        return String.format("STUD%03d", studentId);
//    }
    
    private String firstName;
    
    private String lastName;
    
//    @Column(nullable = false, unique=true)
//    private String email;
//    
//    private String password;
    
//    private LocalDate dateOfBirth;
    
    private String gender;
    
    private long phoneNumber;
    
//    private String degree;
//    
//    private String degreeStream;
//    
//    private byte[] profilePicture;
//    
//    @ManyToOne
//    @JoinColumn(name = "admin_id")
//    private Admin admin;

}
