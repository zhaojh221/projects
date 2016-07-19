package com.suntakpcb.weather.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WeatherServlet extends HttpServlet{

	private static final long serialVersionUID = -4393609501367610884L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String address = "https://query.yahooapis.com/v1/public/yql?q=select * from json where url='http://m.weather.com.cn/atad/101280601.html'&format=json&callback=yqlCallback";
		URL url = new URL(URLEncoder.encode(address,"utf-8"));
		URLConnection conn = url.openConnection();
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line = "";
		resp.setCharacterEncoding("GBK");
		while((line=reader.readLine())!=null){
			System.out.println(line);
		}
	}
}
