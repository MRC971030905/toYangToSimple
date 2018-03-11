package com.byxy.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.byxy.entity.MrcUser;
import com.byxy.service.MrcUserService;
import com.opensymphony.xwork2.ActionSupport;

public class MrcUserLoginAction extends ActionSupport {
	@Resource
	private MrcUserService ms;
	
	private MrcUser mu;

	public String login() {
		
		if(null==mu){
			return "error";
		}else{
			if(mu.getUsername().equals(null)||mu.getUsername()==""||mu.getPassword().equals(null)||mu.getPassword()==""){
				
				return "error";
			}else{
				MrcUser m=new MrcUser();
			
				m=ms.getUser(mu.getUsername());
				System.out.println(mu.getUsername());
				System.out.println(mu.getPassword());
				if(null==m){
					return "error";
				}else{
					if(mu.getPassword().equals(m.getPassword())){
						HttpSession session=ServletActionContext.getRequest().getSession();
						session.setAttribute("mu", m);
						System.out.println(m);
						System.out.println("OK");
						return "OK";
					}else{
						return "error";
					}
				}
						
			}
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
