package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entites.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	
	
   
	List<Student> findByStatus(String status);

}
