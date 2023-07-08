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
public class Subject {
    @Id
    private String id;
    private String name;
    private String semister;
    private String marks;
}
