package com.byxy.dao;

import java.util.List;

import com.byxy.entity.Log;

public interface LogDao {
	List<Log> findAll();

	void add(Log l);


	List<Log> find(int curPage, int pageCount);

	int countAll();

}
