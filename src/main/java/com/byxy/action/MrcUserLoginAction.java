package com.byxy.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.byxy.entity.MrcUser;
import com.byxy.entity.Student;
import com.byxy.service.MrcUserService;
import com.byxy.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;

public class MrcUserLoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private MrcUserService ms;

	@Resource
	private StudentService ss;
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
				Student s = new Student();
				s = ss.getUser(mu.getUsername());// 查询数据库(普通用户)
				m = ms.getUser(mu.getUsername());// 查询数据库(管理员)
				System.out.println(s + "这个普通用户");
				System.out.println(m + "这是管理员");
				if (null == s && null == m) {// 用户不存在
					return "error";
				} else {
					if (null == s && null != m) {// 用户是管理员
						if (m.getPassword().equals(mu.getPassword())) {
							System.out.println("管理员登录");
							ServletActionContext.getRequest().getSession().setAttribute("mu", m);
							ServletActionContext.getRequest().getSession().setAttribute("name", m.getUsername());
							return "admin";
						} else {
							return "error";
						}

					} else {
						if (mu.getPassword().equals(s.getPassword())) {
							ServletActionContext.getRequest().getSession().setAttribute("mu", mu);
							ServletActionContext.getRequest().getSession().setAttribute("name", s.getName());
							return "success";
						} else {
							ServletActionContext.getRequest().getSession().setAttribute("error", "用户或密码不正确");
							return "error";
						}
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
