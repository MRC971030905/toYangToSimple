package com.byxy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.byxy.dao.AdminDao;
import com.byxy.entity.Admin;
import com.byxy.service.AdminService;
@Service
public class AdminServiceIpml implements AdminService {
	@Resource
	private AdminDao ad;
	
	
	@Override
	public void add(Admin a) {
		ad.add(a);	
	}

	@Override
	public void update(Admin a) {
		ad.update(a);
		
	}

	@Override
	public Admin getAdminName(String name) {
		
		return ad.getAdminName(name);
	}


}
