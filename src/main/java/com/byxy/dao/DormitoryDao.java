package com.byxy.dao;

import java.util.List;

import com.byxy.entity.Dormitory;

public interface DormitoryDao {
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
	 * 分页
	 * @param pos
	 * @param rows
	 * @return
	 */
	List<Dormitory> find(int pos,int rows);
	
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
