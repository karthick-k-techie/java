package com.example.springbootcrudproject.repo;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootcrudproject.entity.Student;

public interface StudentRepository extends JpaRepository<Student, UUID> {
}