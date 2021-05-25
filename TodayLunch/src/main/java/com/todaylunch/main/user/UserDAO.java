package com.todaylunch.main.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.todaylunch.main.DbUtils;


public class UserDAO {
	public static int joinUser(UserEntity param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO lunch_user (uid, upw, unm) VALUES (?, ?, ?)";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			ps.setString(2, param.getUpw());
			ps.setString(3, param.getUnm());
			
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			DbUtils.close(con, ps);
		}
	}
	public static UserEntity selUser(UserEntity param) {
		UserEntity vo = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT iuser, uid, upw, unm FROM lunch_user WHERE uid = ?";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int iuser = rs.getInt("iuser");
				String uid = rs.getString("uid");
				String upw = rs.getString("upw");
				String unm = rs.getString("unm");
				vo = new UserEntity();
				vo.setIuser(iuser);
				vo.setUid(uid);
				vo.setUpw(upw);
				vo.setUnm(unm);
			}
			return vo;
		} catch (Exception e) {
			e.printStackTrace();
			return vo;
		} finally {
			DbUtils.close(con, ps);
		}
	}
	public static int selIdChk(String uid) {
		// TODO Auto-generated method stub
		return 0;
	}
}
