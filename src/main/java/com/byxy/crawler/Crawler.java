package com.byxy.crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * 
 * 爬取校园网上的信息
 * 
 * @author Mrc
 *
 */
public class Crawler {

	/**
	 * 获取网页源代码
	 * 
	 * @return
	 */
	public static String htmlSource(String encoding) {
		String newHtml = null;
		StringBuffer sb = new StringBuffer();
		InputStreamReader in = null;
		try {
			URL url = new URL("http://www.byxy.com/html/cn/news/");
			// 打开网络连接
			URLConnection uc = url.openConnection();
			// 伪装
			uc.setRequestProperty("User-Agent", "java");
			// 文件传输
			InputStream is = uc.getInputStream();
			in = new InputStreamReader(is, encoding);
			// 缓冲
			BufferedReader bf = new BufferedReader(in);
			// 创建一个临时空间
			String line = null;
			while ((line = bf.readLine()) != null) {
				//把数据添加到StringBuffer里面
				sb.append(line);
			}
			// 将StringBuffer转为Document
			Document doc = Jsoup.parse(sb.toString());
			// 获取class为listpage ul下面的内容
			Elements elements = doc.getElementsByClass("listpage").select("ul");
			// 把elements 所有东西赋值与newHtml
			newHtml = elements.html();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != in)
					in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return newHtml;
	}
}
