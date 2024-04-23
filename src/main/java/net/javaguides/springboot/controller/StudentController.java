package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Student;
import net.javaguides.springboot.repository.StudentRepository;

@CrossOrigin(origins = "http://localhost:4200")
// @CrossOrigin
@RestController
@RequestMapping("students")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;

	public StudentRepository getStudentRepository() {
		return studentRepository;
	}

	public void setStudentRepository(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
//	@GetMapping("/student")
	@GetMapping
	public List<Student> getAllStudent(){
		return studentRepository.findAll();
	} 
	
	@PostMapping("/student")
	public Student createStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable long id) {
		Student student = studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student doesn't exist"));
		return ResponseEntity.ok(student);
	}


	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
	    Student student = studentRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + id));

	    // updating properties
	    student.setFirstname(studentDetails.getFirstname());
	    student.setLastname(studentDetails.getLastname());
	    student.setStreet(studentDetails.getStreet());
	    student.setCity(studentDetails.getCity());
	    student.setState(studentDetails.getState());
	    student.setZip(studentDetails.getZip());
	    student.setEmail(studentDetails.getEmail());
	    student.setTelephone(studentDetails.getTelephone());
	    student.setDate(studentDetails.getDate());
	    student.setMostliked(studentDetails.getMostliked());
	    student.setInterest(studentDetails.getInterest());
	    student.setLikelihood(studentDetails.getLikelihood());
	    student.setComments(studentDetails.getComments());

	    final Student updatedStudent = studentRepository.save(student);
	    return ResponseEntity.ok(updatedStudent);
	}

	@DeleteMapping("/student/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteStudent(@PathVariable Long id){
		Student student = studentRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + id));

		studentRepository.delete(student);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
