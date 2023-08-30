package com.example.demo.Services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.Entites.Student;
import com.example.demo.Exceptions.ResourceNotFoundException;

public interface StudentInterface {

	public ResponseEntity<Student> saveStudentDetais(Student student);

	public ResponseEntity<List<Student>> getStudents();

	public void deleteStudentsbyId(int id);

	public List<Student> getStudentsbystatus(String status) throws ResourceNotFoundException;

	public Student updateStudentsByid(int id, Student students);
	
	

}
