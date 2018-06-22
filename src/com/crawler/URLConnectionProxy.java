package com.crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionProxy {
	public static void main(String[] args) throws IOException {
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("171.97.67.160", 3128));  //���ô���
		URL url = new URL("http://www.w3school.com.cn/b.asp");  
		URLConnection conn = url.openConnection(proxy);  //�Դ���ķ�ʽ��������
		conn.connect(); //����ʵ������
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

