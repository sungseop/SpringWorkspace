package com.ezen.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@211.252.154.93:1521:XE";
		String uid = "spring_user";
		String pass = "ora123";
		
		try {
			// ����Ŭ JDBC ����̹��� �޸𸮿� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uid, pass);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
		return conn;
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Update, Insert, Delete�� ���� �� close() �޼ҵ�
	public static void close(Connection conn, Statement stmt) {
		try {
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}