package com.byxy.service;

import java.util.List;

import com.byxy.entity.Student;

public interface StudentService {
	void delete(Student d);

	List<Student> find();

	Student get(int id);

	long count();

	void add(Student us);

	void update(Student us);

	Student getUser(String username);
	
	List<Student> find(int pos, int rows);
}
