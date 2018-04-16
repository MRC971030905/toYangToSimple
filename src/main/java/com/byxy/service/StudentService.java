package com.byxy.service;

import com.byxy.entity.Student;

public interface StudentService {
	void add(Student us);

	void update(Student us);

	Student getUser(String username);
}
