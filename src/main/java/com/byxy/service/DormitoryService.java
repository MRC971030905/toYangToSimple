package com.byxy.service;

import java.util.List;

import com.byxy.entity.Dormitory;

public interface DormitoryService {
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
