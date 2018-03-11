package com.byxy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.byxy.dao.MrcUserDao;
import com.byxy.entity.MrcUser;
import com.byxy.service.MrcUserService;
@Service
public class MrcUserServiceIpml implements MrcUserService {
	@Resource
	private MrcUserDao md;
	
	
	@Override
	public void add(MrcUser us) {
		md.add(us);	
	}

	@Override
	public void update(MrcUser us) {
		md.update(us);
		
	}

	@Override
	public MrcUser getUser(String username) {
		
		return md.getUserName(username);
	}

}
