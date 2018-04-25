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
	@Resource
	private MrcUserService mrcs;
	private Student mu;

	public String studentZC() {
		if (null == mu.getName() || mu.getName() == "" || null == mu.getPassword() || mu.getPassword() == "") {// 输入为空
			return "error";
		} else {
			Student user = ms.getUser(mu.getName());// 查询学生数据库
			MrcUser u = mrcs.getUser(mu.getName());// 查询管理员数据库
			if (null == user && null == u) {// 判断是否存在这个用户，null代表不存在
				ms.add(mu);// 增加学生
				return "success";
			} else {
				ServletActionContext.getRequest().getSession().setAttribute("alreadyExist", "该账号已存在，请重新输入");
				return "error";
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
