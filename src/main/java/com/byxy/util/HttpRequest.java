package com.byxy.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

public class HttpRequest {

	
	/**
	 * 通过网站域名URL获取该网站的源码
	 * 
	 * @param url
	 *            URL
	 * @param code
	 *            编码：UTF-8
	 * @return null=查询失败否则成功
	 */
	public static String getHtml(String url, String code) {
		String str = null;
		long maxwaittime = 20000;// 设定一个最大等待时间，比如20秒
		boolean flag = true;// 超时标志位
		long l1 = System.currentTimeMillis();// 取系统当前时间

		try {
			// GB2312可以根据需要替换成要读取网页的编码
			BufferedReader in = new BufferedReader(new InputStreamReader(new URL(url).openConnection().getInputStream(), code));

			while ((str = in.readLine()) != null && flag) {
				long l2 = System.currentTimeMillis();
				if (l2 - l1 < maxwaittime) {
					// 此次操作在设定的最大等待时间之内
//					System.out.println("## " + com.mrwhh.util.DateTool.getDate() + " 读取URL成功");
					return str;
				} else {
					// 超时处理
					flag = false;
					System.out.println("## 读取URL超时：\n   URL：" + url);
					return str;
				}
			}
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		return str;
	}

	/**
	 * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址,
	 * 
	 * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？
	 * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。
	 * 
	 * 如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130, 192.168.1.100
	 * 
	 * 用户真实IP为： 192.168.1.110
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public static String getRemortIP(HttpServletRequest request) {
		if (request.getHeader("x-forwarded-for") == null) {
			return request.getRemoteAddr();
		}
		return request.getHeader("x-forwarded-for");
	}

	/**
	 * 获取IP位置
	 * 
	 * @param request
	 * @return 返回位置城市
	 */
	public static String getIpPosition(HttpServletRequest request) {
		String position = null;
		String url = "http://ip.taobao.com/service/getIpInfo.php?ip=" + getIpAddress(request);
		//	String url = "http://ip.taobao.com/service/getIpInfo.php?ip=183.14.29.189" ;
		String html = Conversion.unicodeToChinese(getHtml(url, "UTF-8"));
		JSONObject htmlJson = JSONObject.fromObject(html);
		if (htmlJson.getString("code").equals("0")) {
			JSONObject dataJson = JSONObject.fromObject(htmlJson.getString("data"));
			String city = dataJson.getString("city");
			return city;
		}
		return position;
	}

	/**
	 * 淘宝IP库获取IP所在地
	 * 
	 * @param ip
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getIpLocation(String ip) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		String url = "http://ip.taobao.com/service/getIpInfo.php?ip=" + ip;
		String html = Conversion.unicodeToChinese(getHtml(url, "UTF-8"));
		// 将json字符串转换成jsonObject
		JSONObject jsonObject = JSONObject.fromObject(html);
		if (jsonObject.getString("code").equals("0")) {
			// IP信息正确
			retMap = JSONObject.fromObject(jsonObject.getString("data"));
			retMap.put("location",  retMap.get("region") + "-" + retMap.get("city") );
		} else {
			retMap = jsonObject;
			retMap.put("location", "无效的IP");
		}
		return retMap;
	}

}
