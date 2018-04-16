package com.byxy.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.byxy.entity.MrcUser;
import com.byxy.entity.Student;
import com.byxy.service.MrcUserService;
import com.byxy.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;

public class StudentZCAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private StudentService ms;

	private Student mu;

	public String studentZC() {
		if (mu.getName().equals(null) || mu.getName() == "" || mu.getPassword().equals(null)
				|| mu.getPassword() == "") {// 输入为空
			ServletActionContext.getRequest().getSession().setAttribute("error", "输入不能为空");
			return "error";
		} else {
			Student user = ms.getUser(mu.getName());// 查询数据库
			if (null == user) {// 判断是否存在这个用户，null代表不存在
				ms.add(mu);// 增加用户
				return "success";
			} else {
				if (mu.getName().equals(user.getName())) {
					ServletActionContext.getRequest().getSession().setAttribute("error", "该用户已存在");
					return "error";
				} else {
					return "success";
				}
			}

		}

	}

	public StudentService getMs() {
		return ms;
	}

	public void setMs(StudentService ms) {
		this.ms = ms;
	}

	public Student getMu() {
		return mu;
	}

	public void setMu(Student mu) {
		this.mu = mu;
	}

}
