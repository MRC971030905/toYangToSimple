package com.byxy.dao;

import java.util.List;

import com.byxy.entity.Dormitory;

public interface DormitoryDao {
	/**
	 * ����
	 * @param s
	 */
	void add(Dormitory d);
	
	/**
	 * ɾ��
	 * @param s
	 */
	void delete(Dormitory d);
	
	/**
	 * �޸�
	 * @param s
	 */
	void update(Dormitory d);
	
	/**
	 *���� 
	 * @return
	 */
	List<Dormitory> find();
	
	/**
	 * ��ҳ
	 * @param pos
	 * @param rows
	 * @return
	 */
	List<Dormitory> find(int pos,int rows);
	
	/**
	 * ��ȡid
	 * @param id
	 * @return
	 */
	Dormitory get(int id);
	
	/**
	 * ��ѯ�ж���������
	 * @return
	 */
	long count();
}
