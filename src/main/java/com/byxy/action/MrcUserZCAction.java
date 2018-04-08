package com.byxy.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.byxy.entity.MrcUser;
import com.byxy.service.MrcUserService;
import com.opensymphony.xwork2.ActionSupport;

public class MrcUserZCAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private MrcUserService ms;

	private MrcUser mu;

	public String zc() {

		if (mu.getUsername().equals(null) || mu.getUsername() == "" || mu.getPassword().equals(null)
				|| mu.getPassword() == "") {// 输入为空
			ServletActionContext.getRequest().getSession().setAttribute("error", "输入不能为空");
			return "error";
		} else {
			MrcUser user = ms.getUser(mu.getUsername());// 查询数据库
			if (null == user) {// 判断是否存在这个用户，null代表不存在
				ms.add(mu);// 增加用户
				return "success";
			} else {
				if (mu.getUsername().equals(user.getUsername())) {
					ServletActionContext.getRequest().getSession().setAttribute("error", "该用户已存在");
					return "error";
				} else {
					return "success";
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
