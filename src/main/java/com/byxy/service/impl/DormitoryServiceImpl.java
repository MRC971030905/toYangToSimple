package com.byxy.service.impl;

import java.util.List;


import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.byxy.dao.DormitoryDao;
import com.byxy.entity.Dormitory;
import com.byxy.service.DormitoryService;
@Transactional
@Service
public class DormitoryServiceImpl implements DormitoryService {
	@Resource
	private DormitoryDao dd;

	@Override
	public List<Dormitory> find() {
		return dd.find();
	}

	@Override
	public void add(Dormitory d) {
		
		dd.add(d);
	}

	@Override
	public void delete(Dormitory d) {
		dd.delete(d);
		
	}

	@Override
	public void update(Dormitory d) {
		dd.update(d);
		
	}



	@Override
	public Dormitory get(int id) {
		
		return dd.get(id);
	}

	@Override
	public long count() {
		
		return dd.count();
	}
}
