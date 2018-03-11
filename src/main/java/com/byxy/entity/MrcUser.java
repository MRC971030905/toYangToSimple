package com.byxy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MrcUser {//ÓÃ»§×¢²á
	
	@GeneratedValue
	private int id;
	@Id
	@Column(length=20)
	private String username;
	@Column(length=20,nullable=false)
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
	public MrcUser(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public MrcUser() {
		super();
	}
	@Override
	public String toString() {
		return "MrcUser [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
}
