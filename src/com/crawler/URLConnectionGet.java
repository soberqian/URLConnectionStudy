package com.crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLConnectionGet {

	public static void main(String[] args) throws IOException {
		//��ʼ��URL
		URL url = new URL("http://www.w3school.com.cn/b.asp");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection(); //ʹ��URLConnection������HttpURLConnection
		// //����Input��Output,��ʹ��Cache
		conn.setDoInput(true);   //���� URLConnection �� doInput �ֶε�ֵ����Ϊtrue
		conn.setRequestMethod("GET");  //��������ķ���Get
//		conn.setRequestMethod("POST"); //ע�����ҳֻ��ʹ��GET����
		conn.connect();  //���Ӳ���
		int statusCode = conn.getResponseCode(); //��ȡ��Ӧ״̬��
		String responseBody = null;
		if (HttpURLConnection.HTTP_OK == statusCode) {  //�����Ӧ״̬��Ϊ200
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(conn.getInputStream(), "GBK"));  // ����BufferedReader����������ȡURL����Ӧ ,�������ñ���
			//��ȡ����
			String readLine = null;
			StringBuffer response = new StringBuffer();
			while (null != (readLine = bufferedReader.readLine())) {
				response.append(readLine);
			}

			bufferedReader.close();
			responseBody = response.toString();
		}
		System.out.println(responseBody);
	}
}
