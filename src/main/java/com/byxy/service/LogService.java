package com.byxy.service;

import java.util.List;

import com.byxy.entity.Log;

public interface LogService {
	void add(Log log);

	List<Log> findAll();// 查看所有日志

	List<Log> find(int curPage, int pageCount);// 分页查找

	int countAll();// 一共有多少条日志

}
