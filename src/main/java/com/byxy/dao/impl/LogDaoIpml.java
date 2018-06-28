package com.byxy.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.byxy.dao.LogDao;
import com.byxy.entity.Log;

@Repository
public class LogDaoIpml implements LogDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List<Log> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Log").list();
	}

	@Override
	public List<Log> find(int curPage, int pageCount) {
		return sessionFactory.getCurrentSession().createQuery("from Log").setMaxResults(pageCount)
				.setFirstResult((curPage - 1) * pageCount).list();
	}

	@Override
	public int countAll() {
		long l = (Long) sessionFactory.getCurrentSession().createQuery("Select count(u) from Log u").uniqueResult();
		return (int) l;
	}

	@Override
	public void add(Log log) {
		sessionFactory.getCurrentSession().save(log);
	}

}
