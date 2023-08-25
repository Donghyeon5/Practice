package org.galapagos.jelly.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcUtil {
	static Connection conn = null;
	static { // static 초기화 블록
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "glory";
			String password = "1234";
			conn = DriverManager.getConnection(url, id, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return conn;
	}

	public static void close() {
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

//public class jdbcUtil {
//
//	static Connection conn = null;
//	static { // static 초기화 블록
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			String url = "jdbc:oracle:thin:@localhost:1521:xe";
//			String id = "jdbc_ex";
//			String password = "jdbc_ex";
//			conn = DriverManager.getConnection(url, id, password);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static Connection getConnection() {
//		return conn;
//	}
//
//	public static void close() {
//		try {
//			if (conn != null) {
//				conn.close();
//				conn = null;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//}
