package com.byxy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.byxy.dao.LogDao;
import com.byxy.entity.Log;
import com.byxy.service.LogService;

@Service
public class LogServiceIpml implements LogService {
	@Resource
	private LogDao logDao;

	@Override
	public List<Log> find(int curPage, int pageCount) {

		return logDao.find(curPage, pageCount);
	}

	@Override
	public int countAll() {
		return logDao.countAll();
	}

	@Override
	public List<Log> findAll() {
		return logDao.findAll();
	}

	@Override
	public void add(Log log) {
		logDao.add(log);
	}

}
