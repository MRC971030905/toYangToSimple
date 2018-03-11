package com.byxy.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Log {
	@Id
	@GeneratedValue
	private Integer id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date beginDate;
	private Long ntime;
	private String name;
	private String model;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Long getNtime() {
		return ntime;
	}
	public void setNtime(Long ntime) {
		this.ntime = ntime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Log(Integer id, Date beginDate, Long ntime, String name, String model) {
		super();
		this.id = id;
		this.beginDate = beginDate;
		this.ntime = ntime;
		this.name = name;
		this.model = model;
	}
	public Log() {
		super();
	}
	@Override
	public String toString() {
		return "Log [id=" + id + ", beginDate=" + beginDate + ", ntime=" + ntime + ", name=" + name + ", model=" + model
				+ "]";
	}
	
}
