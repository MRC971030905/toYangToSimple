package com.byxy.dao;

import java.util.List;

import com.byxy.entity.Student;

public interface StudentDao {

	void add(Student stu);

	void delete(Student stu);

	void update(Student stu);

	List<Student> find();

	List<Student> find(int pos, int rows);

	Student get(int id);

	Student getName(String name);

	long count();
}
