package com.example.demo.Services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Entites.Student;
import com.example.demo.Exceptions.ResourceNotFoundException;
import com.example.demo.Repository.StudentRepo;

@Service
public class StudentInterfaceImpl implements StudentInterface {
	
	
	@Autowired
	private StudentRepo studentrepo;

	@Override
	public  ResponseEntity<Student> saveStudentDetais(Student student) {
		
		return new ResponseEntity<Student>( studentrepo.save(student),HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<Student>> getStudents() {
		
		return new ResponseEntity<>(studentrepo.findAll(),HttpStatus.OK);
	}

	@Override
	public void deleteStudentsbyId(int id) {
		
		studentrepo.deleteById(id);	
		
	}

	@Override
	public List<Student> getStudentsbystatus(String status) throws ResourceNotFoundException {
		List<Student> students=studentrepo.findByStatus(status);
		
		if(students.isEmpty()) {
			throw new ResourceNotFoundException("No records available for this id");
		}
		
		return studentrepo.findByStatus(status);
	}

	@Override
	public Student updateStudentsByid(int id,Student students) {
		
		Student stuts=studentrepo.findById(id).get();
		
		
		if(Objects.nonNull(students.getName())&&!"".equals(students.getName())){
			stuts.setName(students.getName());	
		}
		if(Objects.nonNull(students.getRole())&&!"".equals(students.getRole())) {
			stuts.setRole(students.getRole());
		}
		
		if(Objects.nonNull(students.getStatus())&&!"".equals(students.getRole())) {
			stuts.setStatus(students.getStatus());
		}
		
		return studentrepo.save(stuts);
	}

}
