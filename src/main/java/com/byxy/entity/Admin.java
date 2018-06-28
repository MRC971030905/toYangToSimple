package com.byxy.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Admin implements Serializable {// 序列化

	@GeneratedValue
	private int id;
	@Id
	@Column(length = 20)
	private String username;
	@Column(length = 20, nullable = false)
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public Admin() {
		super();
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

}
