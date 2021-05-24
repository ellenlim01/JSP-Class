package com.koreait.board7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtils {
	public static void main(String[] args) {
		try {
			getCon();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getCon() throws Exception {
		final String DB_NAME = "boardver4";
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		final String URL = "jdbc:mysql://localhost:3308/" + DB_NAME;
		// 포트번호가 3306이면 생략가능
		final String USER_NAME = "root";
		final String PASSWORD = "koreait";

		Class.forName(DRIVER);
		Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		// connection은 리소스 굉장히 많이 먹는다
		System.out.println("연결성공");
		return con;
	}

	public static void close(Connection con, PreparedStatement ps) {
		close(con, ps, null);
	}

	// 열리는순서 con ,ps, rs
	// 닫는순서 rs, ps, con
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
