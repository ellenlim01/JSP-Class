package com.koreait.board6.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board6.DbUtils;


public class BoardDAO {
	public static int getAllPage(BoardVO param) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT ceil(COUNT(*) / ?) FROM t_board ";
		
		int result = 0;
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getPage());
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);//컬럼수는 0이 아니라 1부터 시작
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}
		
		return 0;
	}
	public static List<BoardVO> selBoardList(BoardVO param) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT A.iboard, A.title, A.regdt, A.iuser, B.iuser, B.unm "
				+ " FROM t_board A LEFT JOIN t_user B "
				+ " ON A.iuser = B.iuser "
				+ " ORDER BY A.iboard DESC"
				+ " LIMIT ?, ? ";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getsIdx());
			ps.setInt(2, param.getPage());
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
}
