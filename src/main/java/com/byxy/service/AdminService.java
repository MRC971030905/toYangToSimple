package com.byxy.service;

import com.byxy.entity.Admin;

public interface AdminService {
	void add(Admin a);// 增加管理员

	void update(Admin a);// 修改管理员信息

	Admin getAdminName(String name);// 查询管理员
}
