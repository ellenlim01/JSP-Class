package com.koreait.board6.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board6.DbUtils;


public class BoardDAO {
	public static int getAllPage(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT ceil(COUNT(*) / ?) FROM t_board " 
				+ " WHERE title LIKE ? ";
		
		int result = 0;
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getPage());
			ps.setString(2, "%" + param.getSearch() + "%");
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);//컬럼수는 0이 아니라 1부터 시작
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}
		
		return result;
	}
	public static List<BoardVO> selBoardList(BoardVO param) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT A.iboard, A.title, A.regdt, A.iuser, B.iuser, B.unm "
				+ " FROM t_board A INNER JOIN t_user B "
				+ " ON A.iuser = B.iuser "
				+ " WHERE title LIKE ? "
				+ " ORDER BY A.iboard DESC"
				+ " LIMIT ?, ? ";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, "%" + param.getSearch() + "%");
			ps.setInt(2, param.getsIdx());
			ps.setInt(3, param.getPage());
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
}
