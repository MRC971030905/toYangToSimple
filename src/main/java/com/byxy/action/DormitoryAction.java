package com.byxy.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.byxy.entity.Dormitory;
import com.byxy.service.DormitoryService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class DormitoryAction extends ActionSupport {
	@Resource
	private DormitoryService dormitoryService;

	private List<Dormitory> list;

	private Dormitory d;

	private int count;
	private JSONObject jsonData =new JSONObject();

	public JSONObject getJsonData() {
		return jsonData;
	}
	public void setJsonData(JSONObject jsonData) {
		this.jsonData = jsonData;
	}
	public String getWeather(){
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
	

	public String list() {
		list = dormitoryService.find();
		count = (int) dormitoryService.count();
		return "OK";
	}

	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String method = request.getMethod();

		if ("post".equalsIgnoreCase(method)) {
			System.out.println(d);
			dormitoryService.update(d);
			System.out.println("updated");
			return "OK";
		} else {
			d = dormitoryService.get(d.getdId());
			System.out.println(d);
			System.out.println("get is ok");
			return "NO";
		}
	}

	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String method = request.getMethod();
		if ("post".equalsIgnoreCase(method)) {
			dormitoryService.add(d);
			return "OK";
		} else {
			return "NO";
		}

	}

	public String dele() {
		System.out.println("deleted");
		dormitoryService.delete(d);
		return "OK";
	}

	public List<Dormitory> getList() {
		return list;
	}

	public void setList(List<Dormitory> list) {
		this.list = list;
	}

	public Dormitory getD() {
		return d;
	}

	public void setD(Dormitory d) {
		this.d = d;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
