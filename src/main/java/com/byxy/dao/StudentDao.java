package com.byxy.dao;

import com.byxy.entity.Student;

public interface StudentDao {
	void add(Student st);
	void update(Student st);
	Student getUserName(String name);
}
