package com.byxy.service;

import java.util.List;

import com.byxy.entity.Dormitory;

public interface DormitoryService {
	/**
	 * 增加
	 * @param s
	 */
	void add(Dormitory d);
	
	/**
	 * 删除
	 * @param s
	 */
	void delete(Dormitory d);
	
	/**
	 * 修改
	 * @param s
	 */
	void update(Dormitory d);
	
	/**
	 *遍历 
	 * @return
	 */
	List<Dormitory> find();
	

	
	/**
	 * 获取id
	 * @param id
	 * @return
	 */
	Dormitory get(int id);
	
	/**
	 * 查询有多少条数据
	 * @return
	 */
	long count();
	
}
