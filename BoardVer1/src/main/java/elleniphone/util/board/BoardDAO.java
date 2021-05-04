package elleniphone.util.board;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<BoardVO> selList() {
		List<BoardVO> list = new ArrayList<BoardVO>();

		String sql = "SELECT * FROM iphone";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO();
				list.add(vo);

				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				Date regitime = rs.getDate("regitime");

				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegitime(regitime);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}

		return list;
	}

	public int insertBoard(BoardVO vo) {

		String sql = "INSERT INTO iphone (title, content) VALUES (?, ?) ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getContent());

			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}

		return 0;

	}

	public BoardVO selBoard(int iboard) {

		String sql = "SELECT * FROM iphone WHERE iboard = ?";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			rs = ps.executeQuery();

			if (rs.next()) {
				BoardVO vo = new BoardVO();

				String title = rs.getString("title");
				String content = rs.getString("content");
				Date regitime = rs.getDate("regitime");

				vo.setTitle(title);
				vo.setContent(content);
				vo.setRegitime(regitime);

				return vo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return null;
	}
	
	public int updBoard(BoardVO param) {
		
		String sql = "UPDATE iphone SET title='?', content='?' WHERE iboard=?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getContent());
			ps.setInt(3, param.getIboard());
		
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return 0;
	
	}
}