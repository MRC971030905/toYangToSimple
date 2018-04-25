package com.byxy.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.byxy.dao.StudentDao;
import com.byxy.entity.Student;

@Transactional
@Repository
public class StudentDaoIpml implements StudentDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void add(Student stu) {

		sessionFactory.getCurrentSession().save(stu);
	}

	@Override
	public void update(Student stu) {
		sessionFactory.getCurrentSession().update(stu);
	}

	@Override
	public List<Student> find() {
		return sessionFactory.getCurrentSession()
				.createQuery("from " + Student.class.getSimpleName() + " s where s.del=false").list();
	}

	@Override
	public List<Student> find(int pos, int rows) {
		return sessionFactory.getCurrentSession()
				.createQuery("from " + Student.class.getSimpleName() + " s where s.del=false").setFirstResult(pos)
				.setMaxResults(rows).list();
	}

	@Override
	public Student get(int id) {

		return (Student) sessionFactory.getCurrentSession().get(Student.class, id);
	}

	@Override
	public long count() {
		return (Long) sessionFactory.getCurrentSession()
				.createQuery("select count(u) from " + Student.class.getSimpleName() + " u ").uniqueResult();
	}

	@Override
	public Student getName(String name) {
		return (Student) sessionFactory.getCurrentSession().createQuery(" from Student where name =:name")
				.setParameter("name", name).uniqueResult();
	}

	@Override
	public void delete(Student stu) {
		stu = (Student) sessionFactory.getCurrentSession().get(Student.class, stu.getId());
		stu.setDel(true);
		sessionFactory.getCurrentSession().update(stu);// 逻辑删除
	}

}
