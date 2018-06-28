package com.byxy.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.byxy.entity.Admin;
import com.byxy.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 注册action
 * 
 * @author Mrc
 *
 */
public class SignInAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	private AdminService as;

	private Admin a;

	/**
	 * 注册
	 */
	public String signIn() {

		if (a.getUsername().equals(null) || a.getUsername() == "" || a.getPassword().equals(null)
				|| a.getPassword() == "") {// 输入为空
			ServletActionContext.getRequest().getSession().setAttribute("error", "输入不能为空");
			return "error";
		} else {
			Admin admin = as.getAdminName(a.getUsername());// 查询数据库
			if (null == admin) {// 判断是否存在这个用户，null代表不存在
				as.add(a);// 增加用户
				return "success";
			} else {
				if (a.getUsername().equals(admin.getUsername())) {
					ServletActionContext.getRequest().getSession().setAttribute("error", "该用户已存在");
					return "error";
				} else {
					return "success";
				}
			}

		}

	}

	public AdminService getMs() {
		return as;
	}

	public void setMs(AdminService ms) {
		this.as = ms;
	}

	public Admin getMu() {
		return a;
	}

	public void setMu(Admin mu) {
		this.a = mu;
	}

}
