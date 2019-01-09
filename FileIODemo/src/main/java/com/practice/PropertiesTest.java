package com.practice;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {
	private String name;
	public static void main(String[] args) {
		new PropertiesTest().getName();
	}
	/**
	 * 在maven项目下读取properties文件
	 */
	private void getName(){
		//创建Properties对象
		Properties prop =new Properties();
		//利用反射的方式获取properties的输入流对象
		InputStream in = this.getClass().getResourceAsStream("/name.properties");
		try {
			//通过输入流写入properties对象
			prop.load(in);
			//获取properties对象的属性值
		 	name = prop.getProperty("name");
		 	System.out.println("hello,"+name);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
