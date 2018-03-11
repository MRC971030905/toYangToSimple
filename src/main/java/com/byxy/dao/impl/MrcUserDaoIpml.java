package com.byxy.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.byxy.dao.MrcUserDao;
import com.byxy.entity.MrcUser;
@Repository
public class MrcUserDaoIpml implements MrcUserDao{
	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public void add(MrcUser ud) {
		sessionFactory.getCurrentSession().save(ud);
	}

	@Override
	public void update(MrcUser ud) {
		sessionFactory.getCurrentSession().update(ud);
	}

	@Override
	public MrcUser getUserName(String username) {
		return (MrcUser)sessionFactory.getCurrentSession().get(MrcUser.class, username);
		
	}

}
