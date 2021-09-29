package com.crud.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.api.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
