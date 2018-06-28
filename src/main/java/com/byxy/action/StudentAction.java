package com.byxy.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.byxy.entity.Student;
import com.byxy.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 学生Action
 * 
 * @author Mrc
 *
 */
public class StudentAction extends ActionSupport {
	@Resource
	private StudentService studentService;

	private List<Student> list;

	private Student stu;

	private int count;

	/**
	 * 查询学生信息
	 */
	public String list() {
		list = studentService.find();
		count = (int) studentService.count();
		System.out.println("find is ok");
		return "success";
	}

	/**
	 * 修改学生信息
	 */
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String method = request.getMethod();
		if ("post".equalsIgnoreCase(method)) {
			studentService.update(stu);
			System.out.println("updated");
			return "success";
		} else {
			stu = studentService.get(stu.getId());
			System.out.println("get is ok");
			return "error";
		}
	}

	/**
	 * 增加学生信息
	 */
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String method = request.getMethod();
		System.out.println("method=" + method);
		if ("post".equalsIgnoreCase(method)) {
			studentService.add(stu);
			return "success";
		} else {
			return "error";
		}

	}

	/**
	 * 删除学生信息
	 */
	public String dele() {
		studentService.delete(stu);
		System.out.println("deleted");
		return "success";
	}

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
