package com.byxy.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.byxy.crawler.Crawler;
import com.byxy.entity.Log;
import com.byxy.entity.Admin;
import com.byxy.entity.Student;
import com.byxy.service.AdminService;
import com.byxy.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

/**
 * 登录action
 * 
 */
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	private AdminService ms;
	@Resource
	private StudentService ss;
	private JSONObject jsonData = new JSONObject();
	private String name;// 用户名(用来接收前端数据)
	private String password;// 密码(用来接收前端数据)
	private Log log;// 日志
	private String ht;// html
	private Integer i;

	/**
	 * 登录
	 * 
	 */
	public String login() {
		Crawler crawler = new Crawler();// 创建爬虫对象
		ht = crawler.htmlSource("utf-8");// 爬取校园网公告
		ServletActionContext.getRequest().getSession().setAttribute("ht", ht);// 设置session
		if (null == name || name == "" || null == password || password == "") {// 判断用户名和密码是否有空的
			ServletActionContext.getRequest().getSession().setAttribute("error02", "请输入账号或密码");// 设置session
			return "error";
		} else {
			Admin m = new Admin();
			Student s = new Student();
			s = ss.getUser(name);// 查询数据库(普通用户)
			m = ms.getAdminName(name);// 查询数据库(管理员)
			if (null == s && null == m) {// 用户不存在
				return "error";
			} else {

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

	/**
	 * 天气查询
	 * 
	 */
	public String getWeather() {
		HttpServletRequest request = ServletActionContext.getRequest();// 获取返回的request
		String name = com.byxy.util.HttpRequest.getIpPosition(request);// 获取返回来的城市名字
		System.out.println(name);
		String url = "http://restapi.amap.com/v3/weather/weatherInfo?key=3572715c5e31dd109f285537e13c3c25&city="
				+ com.byxy.util.Conversion.UrlEncode(name);// 字符串你拼接
		System.out.println(url);
		String retStr = com.byxy.util.HttpRequest.getHtml(url, "utf-8");// 根据获得的城市调用api查询
		System.out.println(retStr);
		jsonData = JSONObject.fromObject(retStr);
		return SUCCESS;
	}

	/**
	 * 操作日志
	 * 
	 */
	public String log() {
		log = (Log) ServletActionContext.getRequest().getSession().getAttribute("log");
		System.out.println(log.getBeginDate());
		return "success";
	}

	public AdminService getMs() {
		return ms;
	}

	public void setMs(AdminService ms) {
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

	public Integer getI() {
		return i;
	}

	public void setI(Integer i) {
		this.i = i;
	}

}
