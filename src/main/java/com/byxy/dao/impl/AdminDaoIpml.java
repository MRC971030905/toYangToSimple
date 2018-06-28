package com.byxy.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.byxy.dao.AdminDao;
import com.byxy.entity.Admin;
@Repository
public class AdminDaoIpml implements AdminDao{
	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public void add(Admin a) {
		sessionFactory.getCurrentSession().save(a);
	}

	@Override
	public void update(Admin a) {
		sessionFactory.getCurrentSession().update(a);
	}

	@Override
	public Admin getAdminName(String name) {
		return (Admin)sessionFactory.getCurrentSession().get(Admin.class, name);
		
	}

}
