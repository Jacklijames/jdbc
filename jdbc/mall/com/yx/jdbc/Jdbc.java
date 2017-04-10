package com.yx.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc {
	private static Connection conn = null;

	static {
		try {// 获取数据库连接；
			conn = DriverManager.getConnection(
					"jdbc:mysql://192.168.8.128:3306/test", "root", "feng456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {// 加载驱动引擎
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {
		return conn;
	}
}
