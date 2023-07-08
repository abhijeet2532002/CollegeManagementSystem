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
public class Student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String motherName;
    private String email;
    private String phone;
    private String aadhar;
    private String std;
    private String category;
    private String document;
    private String address;
}
