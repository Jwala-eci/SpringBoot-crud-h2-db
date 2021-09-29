package com.crud.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.api.dao.StudentRepository;
import com.crud.api.model.Student;



@Service
public class StudentServiceImp implements StudentSevices {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public List<Student> createStudents(List<Student> students) {
		// TODO Auto-generated method stub
		return studentRepository.saveAll(students);
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).orElse(null);
	}

	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}
	
	 @Override
	 public void updateStudent(int id, Student student) {
		 Student studentUpdate = studentRepository.findById(id).get();
		 System.out.println(studentUpdate.toString());
		 studentUpdate.setName(student.getName());
		 studentUpdate.setCourse(student.getCourse());
		 studentUpdate.setFees(student.getFees());
		 studentRepository.save(studentUpdate);
	 }


	@Override
	public String deleteStudentById(int id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
		return "Student got deleted";
	}

	@Override
	public String deleteAll() {
		// TODO Auto-generated method stub
		studentRepository.deleteAll();
		return "All Students Got Deleted";
	}

}
