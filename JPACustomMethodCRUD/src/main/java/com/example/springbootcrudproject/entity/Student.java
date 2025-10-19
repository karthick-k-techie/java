package com.example.springbootcrudproject.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "STUDENT")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
	// The primary key of the default
	@Id
	// Auto-generate the ID value, in this case a UUID.
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id")
	private UUID id;
	@Column(name = "first_name") // Customize column names as appropriate for Java objects.
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private String email;
	private String major;
	private double credits;
	private double gpa;

}