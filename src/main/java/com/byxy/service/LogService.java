package com.byxy.service;

import java.util.List;

import com.byxy.entity.Log;

public interface LogService {
	
	public List<Log> find(int curPage, int pageCount);
	
	public int countAll();
	
	public List<Log> findAll();
	
	public void add(Log l);
}
