package com.yx.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {

	private static Connection conn=null;
	
	
	static{

        try {//加载驱动引擎
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 try {//获取数据库连接；
			conn = DriverManager.getConnection(  
			         "jdbc:mysql://192.168.8.128:3306/test" ,"root", "feng456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    
  
	}
	
	
	public static Connection getConnection(){
		return conn;
	}
	/*
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//获取数据库的连接。
		java.sql.Connection conn = DriverManager.getConnection(  
	                    "jdbc:mysql://192.168.8.128:3306/test" ,"root", "feng456");  
	      //加载驱动程序
	            Class.forName("com.mysql.jdbc.Driver");  
	     
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery("select user_name,age,id from imooc_goddess");
		
	            while(rs.next()){
	            	System.out.println(rs.getNString("user_name")+ "," + rs.getInt("age"));
	            }
	           
	}*/

}
