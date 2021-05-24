package com.koreait.board7.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board7.DbUtils;



public class BoardDAO {
	public static List<BoardDomain> selBoardList() {
		List<BoardDomain> list = new ArrayList<BoardDomain>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT A.iboard, A.title, A.regdt, A.iuser, B.iuser, B.unm as writerNm "
				+ " FROM t_board A LEFT JOIN t_user B "
				+ " ON A.iuser = B.iuser "
				+ " ORDER BY A.iboard DESC";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				BoardDomain param = new BoardDomain();
				
				param.setIboard(rs.getInt("iboard"));
				param.setTitle(rs.getString("title"));
				param.setRegdt(rs.getString("regdt"));
				param.setIuser(rs.getInt("iuser"));
				param.setWriterNm(rs.getString("writerNm"));
				list.add(param);
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
