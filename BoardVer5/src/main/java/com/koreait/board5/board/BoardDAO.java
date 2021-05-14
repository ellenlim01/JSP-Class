package com.koreait.board5.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board5.DbUtils;

public class BoardDAO {

	public static List<BoardVO> selList() {
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
			List<BoardVO> list = new ArrayList<BoardVO>();
			
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
			DbUtils.close(con, ps);
		}
	}

	public static BoardVO selBoard(int iboard) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT A.iboard, A.title, A.regdt, A.ctnt, A.iuser, B.iuser, B.unm "
				+ " FROM t_board A LEFT JOIN t_user B "
				+ " ON A.iuser = B.iuser WHERE A.iboard = ?";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				BoardVO vo = new BoardVO();
				
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setUnm(rs.getString("unm"));
				vo.setCtnt(rs.getString("ctnt"));
				
				return vo;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DbUtils.close(con, ps);
		}
		return null;
	}
	
}
