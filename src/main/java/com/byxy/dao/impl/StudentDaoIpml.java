package com.byxy.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.byxy.dao.StudentDao;
import com.byxy.entity.Student;
@Repository
public class StudentDaoIpml implements StudentDao{
	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public void add(Student ud) {
		sessionFactory.getCurrentSession().save(ud);
	}

	@Override
	public void update(Student ud) {
		sessionFactory.getCurrentSession().update(ud);
	}

	@Override
	public Student getUserName(String name) {
		return (Student)sessionFactory.getCurrentSession().createQuery(" from Student where name =:name").setParameter("name", name).uniqueResult();
		
	}

}
