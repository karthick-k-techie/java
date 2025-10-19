package com.example.springbootcrudproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootcrudproject.entity.Student;
import com.example.springbootcrudproject.repo.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> finaAll() {
		return studentRepository.findAll();
	}
}
