package com.crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionTimeOut {
	public static void main(String[] args) throws IOException {
		//��ʼ��URL
		URL url = new URL("http://www.w3school.com.cn/b.asp");
		URLConnection conn =  url.openConnection(); //ʹ��URLConnection������HttpURLConnection
//		HttpURLConnection conn = (HttpURLConnection) url.openConnection()
		//�������ͷ��Ϣ
		conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");  
		conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9"); 
		conn.setRequestProperty("Host", "www.w3school.com.cn"); 
		conn.setRequestProperty("Cache-Control", "max-age=0"); 
		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.108 Safari/537.36"); 
		conn.setConnectTimeout(30000);  
		conn.setReadTimeout(30000);  
		conn.connect();

		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(conn.getInputStream(), "gbk"));  // ����BufferedReader����������ȡURL����Ӧ ,�������ñ��� 
		String line; 
		String html = "";
		while ((line = bufferedReader.readLine()) != null) {  
			html +=  line;  
		}  
		System.out.println(html);
	}
}

