package com.byxy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Dormitory {//����

	@Id
	@GeneratedValue
	private int dId;//����
	@Column(nullable=false,length=20)
	private String name;//����
	@Column(nullable=false,length=50)
	private String className;//�༶����
	@Column(nullable=false,length=50)
	private String departmentName;//ϵ
	@Column(length=10)
	private Float height;//���
	@Column(length=10)
	private Float weight;//����
	@Column(length=20)
	private String phone;//�绰
	@Column(length=20)
	private String tim;//qq
	@Column(length=20)
	private String weChat;//΢��
	@Column(length=50)
	private String area ;//��������
	@Column(length=50)
	private String dormitory;//��������
	
	private int dele=1;
	
	
	public int getDele() {
		return dele;
	}
	public void setDele(int dele) {
		this.dele = dele;
	}
	public int getdId() {
		return dId;
	}
	public void setdId(int dId) {
		this.dId = dId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Float getHeight() {
		return height;
	}
	public void setHeight(Float height) {
		this.height = height;
	}
	public Float getWeight() {
		return weight;
	}
	public void setWeight(Float weight) {
		this.weight = weight;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTim() {
		return tim;
	}
	public void setTim(String tim) {
		this.tim = tim;
	}
	public String getWeChat() {
		return weChat;
	}
	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDormitory() {
		return dormitory;
	}
	public void setDormitory(String dormitory) {
		this.dormitory = dormitory;
	}
	@Override
	public String toString() {
		return "Dormitory [dId=" + dId + ", name=" + name + ", className=" + className + ", departmentName="
				+ departmentName + ", height=" + height + ", weight=" + weight + ", phone=" + phone + ", tim=" + tim
				+ ", weChat=" + weChat + ", area=" + area + ", dormitory=" + dormitory + "]";
	}
	public Dormitory(int dId, String name, String className, String departmentName, Float height, Float weight,
			String phone, String tim, String weChat, String area, String dormitory) {
		super();
		this.dId = dId;
		this.name = name;
		this.className = className;
		this.departmentName = departmentName;
		this.height = height;
		this.weight = weight;
		this.phone = phone;
		this.tim = tim;
		this.weChat = weChat;
		this.area = area;
		this.dormitory = dormitory;
	}
	public Dormitory() {
		super();
	}
	
	
}
