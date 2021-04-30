package com.koreait.board3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//Data Access Object (DB 담당)
public class BoardDAO {

	// 글 등록
	public static int insertBoard(BoardVO3 vo) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = " INSERT INTO t_board (title, ctnt) " + "VALUES(?,?) "; // String이면 ''으로 감싸서 들어감

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);

			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());

			return ps.executeUpdate();// 영향받은 행의 개수가 return됨 (int)
			//insert, update, delete 일반적으로 1
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;

	}

	public static List<BoardVO3> selBoardList() {
		List<BoardVO3> list = new ArrayList();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT iboard, title, regdt FROM t_board";
		//query문에서는 ;을 넣으면 안됨
		
		//?를 쓰지 않았기 때문에 try안에서 set을 하지 않아도 됨
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();//sql의 결과물을 가지고 있음
			
			//record가 있으니 true로 있을 때까지 실행, 최초의 rs.next()는 첫번째를 가리킴
			while(rs.next()) {
				BoardVO3 vo = new BoardVO3();
				list.add(vo);
				
				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				String regdt = rs.getString("regdt"); 
				
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegdt(regdt);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		// getCon이 throw를 하고 있기 때문에 try, catch문을 적어줘야 함

		return list;
	}
}
