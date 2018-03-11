package com.byxy.dao;

import com.byxy.entity.MrcUser;

public interface MrcUserDao {
	void add(MrcUser ud);
	void update(MrcUser ud);
	MrcUser getUserName(String username);
}
