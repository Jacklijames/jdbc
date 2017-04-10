package com.yx.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {

	private static Connection conn = null;

	static {
		
		try {// 加载驱动引擎
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {// 获取数据库连接；
			conn = DriverManager.getConnection(
					"jdbc:mysql://192.168.10.206:3306/school", "root", "feng456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	public static Connection getConnection() {
		return conn;
	}
	
	 public static void free(ResultSet rs, Statement ptmt )  
	    {  
	        try {  
	            if(null != rs)  
	            {  
	                rs.close();  
	                rs = null ;  
	            }  
	              
	            if(null != ptmt)  
	            {  
	                ptmt.close();  
	                ptmt = null ;  
	            }  
	              
	           
	              
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }  

}
