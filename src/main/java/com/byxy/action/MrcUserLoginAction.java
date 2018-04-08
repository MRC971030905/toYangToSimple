package com.byxy.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.byxy.entity.MrcUser;
import com.byxy.service.MrcUserService;
import com.opensymphony.xwork2.ActionSupport;

public class MrcUserLoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private MrcUserService ms;

	private MrcUser mu;

	public String login() {
		if (null == mu) {// 判断是否有数据
			return "error";
		} else {
			if (mu.getUsername().equals(null) || mu.getUsername() == "" || mu.getPassword().equals(null)
					|| mu.getPassword() == "") {// 判断用户名和密码是否有空的
				ServletActionContext.getRequest().getSession().setAttribute("error", "请输入账号或密码");
				return "error";
			} else {
				MrcUser m = new MrcUser();
				m = ms.getUser(mu.getUsername());// 查询数据库
				if (null == m) {// 用户不存在
					return "error";
				} else {
					if (mu.getPassword().equals(m.getPassword())) {
						ServletActionContext.getRequest().getSession().setAttribute("mu", m);
						return "success";
					} else {
						ServletActionContext.getRequest().getSession().setAttribute("error", "用户或密码不正确");
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
