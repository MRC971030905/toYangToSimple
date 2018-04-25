package com.byxy.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.byxy.crawler.Crawler;
import com.byxy.entity.Log;
import com.byxy.entity.MrcUser;
import com.byxy.entity.Student;
import com.byxy.service.MrcUserService;
import com.byxy.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class LoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private MrcUserService ms;
	@Resource
	private StudentService ss;

	private JSONObject jsonData = new JSONObject();
	private String name;
	private String password;
	private Log log;
	private String ht;

	public String login() {

		if (null == name || name == "" || null == password || password == "") {// 判断用户名和密码是否有空的
			ServletActionContext.getRequest().getSession().setAttribute("error02", "请输入账号或密码");
			return "error";
		} else {
			MrcUser m = new MrcUser();
			Student s = new Student();
			s = ss.getUser(name);// 查询数据库(普通用户)
			m = ms.getUser(name);// 查询数据库(管理员)
			if (null == s && null == m) {// 用户不存在
				return "error";
			} else {
				Crawler crawler = new Crawler();
				ht = crawler.htmlSource("utf-8");
				if (null == s && null != m) {// 用户是管理员
					if (m.getPassword().equals(password)) {
						System.out.println("管理员登录");
						ServletActionContext.getRequest().getSession().setAttribute("name", m.getUsername());
						return "admin";
					} else {
						return "error";
					}

				} else {
					if (password.equals(s.getPassword())) {// 普通用户登录
						System.out.println("普通用户登录");
						this.name = s.getNickName();
						ServletActionContext.getRequest().getSession().setAttribute("name", s.getNickName());
						return "success";
					} else {
						ServletActionContext.getRequest().getSession().setAttribute("error01", "用户或密码不正确");
						return "error";
					}
				}
			}
		}

	}

	// 天气
	public String getWeather() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String name = com.byxy.util.HttpRequest.getIpPosition(request);
		System.out.println(name);
		String url = "http://restapi.amap.com/v3/weather/weatherInfo?key=3572715c5e31dd109f285537e13c3c25&city="
				+ com.byxy.util.Conversion.UrlEncode(name);
		System.out.println(url);
		String retStr = com.byxy.util.HttpRequest.getHtml(url, "utf-8");
		System.out.println(retStr);
		jsonData = JSONObject.fromObject(retStr);
		return SUCCESS;
	}

	public String log() {// 日志
		log = (Log) ServletActionContext.getRequest().getSession().getAttribute("log");
		System.out.println(log.getBeginDate());

		return "success";
	}

	public MrcUserService getMs() {
		return ms;
	}

	public void setMs(MrcUserService ms) {
		this.ms = ms;
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

	public JSONObject getJsonData() {
		return jsonData;
	}

	public void setJsonData(JSONObject jsonData) {
		this.jsonData = jsonData;
	}

	public Log getLog() {
		return log;
	}

	public void setLog(Log log) {
		this.log = log;
	}

	public String getHt() {
		return ht;
	}

	public void setHt(String ht) {
		this.ht = ht;
	}

}
