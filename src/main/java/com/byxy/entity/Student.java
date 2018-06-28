package com.byxy.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Value;

@Entity
public class Student implements Serializable {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(length = 10)
	private String name;// 账号
	@Column(length = 20)
	private String password;// 密码
	@Column(length = 5, nullable = false)
	private Integer age;// 年龄
	@Column(nullable = false)
	private Boolean sex;// 性别
	@Column(nullable = false)
	private String floor;// 楼层
	@Column(nullable = false)
	private String dorm;// 宿舍

	private String nickName;// 昵称


	@Value("false")
	private Boolean del;// 是否已经删除

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getDorm() {
		return dorm;
	}

	public void setDorm(String dorm) {
		this.dorm = dorm;
	}

	public Student() {
		super();
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}



	public Boolean getDel() {
		return del;
	}

	public void setDel(Boolean del) {
		this.del = del;
	}

	public Student(Integer id, String name, String password, Integer age, Boolean sex, String floor, String dorm,
			String nickName, Boolean del) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
		this.sex = sex;
		this.floor = floor;
		this.dorm = dorm;
		this.nickName = nickName;
		this.del = del;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", password=" + password + ", age=" + age + ", sex=" + sex
				+ ", floor=" + floor + ", dorm=" + dorm + ", nickName=" + nickName + ", del=" + del + "]";
	}

	
	

}
