package com.koreait.board4.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board4.DbUtils;

public class UserDAO {
	public static int joinUser(UserVO param) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "INSERT INTO t_user (uid, upw, unm, gender) VALUES (?, ?, ?, ?)";

		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);

			ps.setString(1, param.getUid());
			ps.setString(2, param.getUpw());
			ps.setString(3, param.getUnm());
			ps.setInt(4, param.getGender());

			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			DbUtils.close(con, ps);
		}
	}

	// 로그인 성공:1 아이디 없음:2 비밀번호틀림:3 에러:0
	public static int loginUser(UserVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT * from t_user WHERE uid = ?";
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);

			ps.setString(1, param.getUid());

			rs = ps.executeQuery();
						
			if (rs.next()) {
				String dbPw = rs.getString("upw");
				
				if (BCrypt.checkpw(param.getUpw(), dbPw)) {
					int iuser = rs.getInt("iuser");
					String unm = rs.getString("unm");
					
					param.setIuser(iuser);
					param.setUnm(unm);
					
					return 1;
				} else {
					return 3;
				}
			} else {
				return 2;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			DbUtils.close(con, ps, rs);
		}

	}
}
