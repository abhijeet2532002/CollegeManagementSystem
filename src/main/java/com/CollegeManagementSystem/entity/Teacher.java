package com.CollegeManagementSystem.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Teacher {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String aadhar;
    private String qualification;
    private String gender;
    private String document;
    private String address;
}
