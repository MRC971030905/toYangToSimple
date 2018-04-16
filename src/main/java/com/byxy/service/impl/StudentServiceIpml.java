package com.byxy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.byxy.dao.StudentDao;
import com.byxy.entity.Student;
import com.byxy.service.StudentService;

@Service
public class StudentServiceIpml implements StudentService {
	@Resource
	private StudentDao md;

	@Override
	public void add(Student us) {
		md.add(us);
	}

	@Override
	public void update(Student us) {
		md.update(us);

	}

	@Override
	public Student getUser(String username) {

		return md.getUserName(username);
	}

}
