package com.byxy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(length=10)
	private String name;//用户名
	@Column(length=20)
	private String password;//密码
	
	private Integer age ;//年龄
	
	private Boolean sex;//性别
	
	private String floor;//楼层
	
	private String dorm;//宿舍

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

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", password=" + password + ", age=" + age + ", sex=" + sex
				+ ", floor=" + floor + ", dorm=" + dorm + "]";
	}

	public Student() {
		super();
	}

	public Student(Integer id, String name, String password, Integer age, Boolean sex, String floor, String dorm) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
		this.sex = sex;
		this.floor = floor;
		this.dorm = dorm;
	}
	
	
}
