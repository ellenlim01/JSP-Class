package com.koreait.board4.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board4.DbUtils;

public class BoardDAO {
	public static int insertBoard(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "INSERT INTO t_board (title, ctnt, iuser) VALUES (?, ?, ?)";
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, vo.getIuser());

			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			DbUtils.close(con, ps);
		}
	}

	public static List<BoardVO> selBoardList() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " SELECT A.iboard, A.title, A.iuser, A.regdt, B.unm " + " FROM t_board A " + " LEFT JOIN t_user B "
				+ " ON A.iuser = B.iuser ORDER BY A.iboard DESC";

		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");
				String unm = rs.getString("unm");

				BoardVO vo = new BoardVO();
				list.add(vo);
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegdt(regdt);
				vo.setUnm(unm);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return list;
	}

	public static BoardVO selBoard(int num) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " SELECT A.iboard, A.title, A.ctnt, A.iuser, A.regdt, B.unm " + " FROM t_board A "
				+ " LEFT JOIN t_user B " + " ON A.iuser = B.iuser WHERE iboard = ?";

		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();

			if (rs.next()) {
				String title = rs.getString("title");
				String ctnt = rs.getString("ctnt");
				String regdt = rs.getString("regdt");
				String unm = rs.getString("unm");
				int iuser = rs.getInt("iuser");

				BoardVO vo = new BoardVO();
				vo.setIboard(num);
				vo.setTitle(title);
				vo.setCtnt(ctnt);
				vo.setRegdt(regdt);
				vo.setUnm(unm);
				vo.setIuser(iuser);

				return vo;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return null;
	}

	public static int delBoard(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "DELETE FROM t_board WHERE iboard = ? AND iuser = ?";

		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getIboard());
			ps.setInt(2, vo.getIuser());
			 return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return 0 ;
		} finally {
			DbUtils.close(con, ps, rs);
		}
	}
}
