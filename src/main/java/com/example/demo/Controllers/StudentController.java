package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entites.Student;
import com.example.demo.Exceptions.ResourceNotFoundException;
import com.example.demo.Services.StudentInterface;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentInterface studentInterface;
	
	
	@PostMapping("/enterDetails")
	public ResponseEntity<Student> enterStudentdetails(@RequestBody Student student) {
		
		return  studentInterface.saveStudentDetais(student);
		
	}
	
	@GetMapping("/getstus")
	public ResponseEntity<List<Student>> getStudents(){
		
		return studentInterface.getStudents();
		
	}
	
	
	@GetMapping("/bystatus/{status}")
	public List<Student> getStudentsBystatus(@PathVariable String status) throws ResourceNotFoundException{
		
		return studentInterface.getStudentsbystatus(status) ;
		
		
	}
	
	@DeleteMapping("/deleted/{id}")
	public String deleteStudentsById(@PathVariable int id) {
		
		studentInterface.deleteStudentsbyId(id);
		
		return "Successfully deleted";
		
	}
	
	@PutMapping("/update/{id}")
	public Student updateStudentsbyId(@PathVariable int id,@RequestBody Student students) {
		
		return studentInterface.updateStudentsByid(id,students);
		
	}


}
