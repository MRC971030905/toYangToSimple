package com.byxy.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.byxy.entity.Admin;
import com.byxy.entity.Student;
import com.byxy.service.AdminService;
import com.byxy.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 学生注册action
 * @author Mrc
 *
 */
public class StudentSignInAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Resource
	private StudentService ss;
	@Resource
	private AdminService ads;

	private Student student;
	/**
	 * 学生注册
	 */
	public String studentZC() {
		if (null == student.getName() || student.getName() == "" || null == student.getPassword()
				|| student.getPassword() == "") {// 输入为空
			return "error";
		} else {
			Student user = ss.getUser(student.getName());// 查询学生数据库
			Admin u = ads.getAdminName(student.getName());// 查询管理员数据库
			if (null == user && null == u) {// 判断是否存在这个用户，null代表不存在
				ss.add(student);// 增加学生
				return "success";
			} else {
				ServletActionContext.getRequest().getSession().setAttribute("alreadyExist", "该账号已存在，请重新输入");
				return "error";
			}

		}

	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
