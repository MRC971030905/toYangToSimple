package com.byxy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.byxy.dao.StudentDao;
import com.byxy.entity.Student;
import com.byxy.service.StudentService;

@Service
public class StudentServiceIpml implements StudentService {
	@Resource
	private StudentDao std;

	@Override
	public void add(Student stu) {
		std.add(stu);
	}

	@Override
	public void update(Student stu) {
		std.update(stu);
	}

	@Override
	public Student getUser(String username) {

		return std.getName(username);
	}

	@Override
	public void delete(Student stu) {
		std.delete(stu);

	}

	@Override
	public List<Student> find() {
		return std.find();
	}

	@Override
	public Student get(int id) {
		return std.get(id);
	}

	@Override
	public long count() {
		return std.count();
	}

	@Override
	public List<Student> find(int pos, int rows) {
		return std.find(pos, rows);
	}

}
