package com.byxy.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.byxy.dao.DormitoryDao;
import com.byxy.entity.Dormitory;

@Repository
public class DormitoryDaoImpl implements DormitoryDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void add(Dormitory d) {
		sessionFactory.getCurrentSession().saveOrUpdate(d);

	}

	@Override
	public void delete(Dormitory d) {

		d = (Dormitory) sessionFactory.getCurrentSession().get(Dormitory.class, d.getdId());
		d.setDele(0);
		sessionFactory.getCurrentSession().update(d);
	}

	@Override
	public void update(Dormitory d) {
		sessionFactory.getCurrentSession().update(d);
	}

	@Override
	public List<Dormitory> find() {
		return sessionFactory.getCurrentSession().createQuery("from " + Dormitory.class.getSimpleName() + " where dele=1 ").list();
	}

	@Override
	public List<Dormitory> find(int pos, int rows) {
		return sessionFactory.getCurrentSession().createQuery("from " + Dormitory.class.getSimpleName() + "  where dele=1")
				.setFirstResult(pos).setMaxResults(rows).list();
	}

	@Override
	public Dormitory get(int id) {
		
		return (Dormitory) sessionFactory.getCurrentSession().get(Dormitory.class, id);
	}

	@Override
	public long count() {
		return (Long) sessionFactory.getCurrentSession()
				.createQuery("select count(u) from " + Dormitory.class.getSimpleName() + " u where u.dele=1").uniqueResult();
	}
}
