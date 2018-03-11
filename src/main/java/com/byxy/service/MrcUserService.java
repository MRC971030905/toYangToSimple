package com.byxy.service;


import com.byxy.entity.MrcUser;



public interface MrcUserService {
 void add(MrcUser us);
 void update(MrcUser us);
 MrcUser getUser(String username);
}
