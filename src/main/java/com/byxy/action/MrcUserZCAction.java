package com.byxy.action;

import javax.annotation.Resource;

import com.byxy.entity.MrcUser;
import com.byxy.service.MrcUserService;
import com.opensymphony.xwork2.ActionSupport;

public class MrcUserZCAction extends ActionSupport {
	@Resource
	private MrcUserService ms;
	
	private MrcUser mu;

	public String zc(){
		if(mu.getUsername().equals(null)||mu.getUsername()==""||mu.getPassword().equals(null)||mu.getPassword()==""){
			
			return "NO";
		}else{
			System.out.println(mu);
			ms.add(mu);
			return "OK";
		}
	}
	
	
	public MrcUserService getMs() {
		return ms;
	}
	public void setMs(MrcUserService ms) {
		this.ms = ms;
	}
	public MrcUser getMu() {
		return mu;
	}
	public void setMu(MrcUser mu) {
		this.mu = mu;
	}
	
	
}
