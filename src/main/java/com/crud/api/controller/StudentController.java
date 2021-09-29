package com.crud.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.api.model.Student;
import com.crud.api.service.StudentSevices;
import com.crud.api.util.AppConstant;

@RestController
@RequestMapping(AppConstant.Api)
public class StudentController {
	
	@Autowired
	private StudentSevices studentService;
	
	@PostMapping("/addStudent")
	public Student addUser(@RequestBody Student student) {
		return studentService.createStudent(student);
	}

	@PostMapping("/addStudents")
	public List<Student> addUsers(@RequestBody List<Student> students) {
		return studentService.createStudents(students);
	}

	@GetMapping(AppConstant.Student +"/{id}")
	public Student getStudentById(@PathVariable int id) {
		return studentService.getStudentById(id);
	}

	@GetMapping(AppConstant.Students)
	public List<Student> getAllStudents() {
		return studentService.getStudents();
	}
	
	@PutMapping(AppConstant.Student +"/{id}")
	public ResponseEntity<Student>  updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
		studentService.updateStudent(id, student);
		return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
		
	}
	
	@DeleteMapping(AppConstant.Student +"/{id}")
	public String deleteStudentById(@PathVariable int id) {
		return studentService.deleteStudentById(id);
	}
	
	@DeleteMapping(AppConstant.Students)
	public String deleteAll() {
		return studentService.deleteAll();
	}


}
