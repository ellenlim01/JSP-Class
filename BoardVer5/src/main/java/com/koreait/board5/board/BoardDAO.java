package com.koreait.board5.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board5.DbUtils;

public class BoardDAO {
	
	public static int insBoard(BoardVO vo) {
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

	public static List<BoardVO> selList() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT A.iboard, A.title, A.regdt, A.iuser, B.iuser, B.unm "
				+ " FROM t_board A LEFT JOIN t_user B "
				+ " ON A.iuser = B.iuser "
				+ " ORDER BY A.iboard DESC";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				BoardVO vo = new BoardVO();
				list.add(vo);
				
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setUnm(rs.getString("unm"));
				
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DbUtils.close(con, ps, rs);
		}
	}

	public static BoardVO selBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT A.iboard, A.title, A.regdt, A.ctnt, A.iuser, B.unm "
				+ " ,if(C.iboard is null, 0, 1) AS isFav "
				+ " FROM t_board A "
				+ " INNER JOIN t_user B "
				+ " ON A.iuser = B.iuser "
				+ " LEFT JOIN t_board_fav C "
				+ " ON A.iboard = C.iboard "
				+ " AND C.iuser = ? "
				+ " WHERE A.iboard = ? ";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIuser());//로그인 user PK
			ps.setInt(2, param.getIboard());//
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				BoardVO vo = new BoardVO();
				
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setUnm(rs.getString("unm"));
				vo.setCtnt(rs.getString("ctnt"));
				vo.setIsFav(rs.getInt("isFav"));
				
				return vo;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return null;
	}

	public static int delBoard(BoardVO vo) {

		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " DELETE from t_board WHERE iboard = ? AND iuser = ? ";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getIboard());
			ps.setInt(2, vo.getIuser());
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			DbUtils.close(con, ps);
		}
	}
	
}
