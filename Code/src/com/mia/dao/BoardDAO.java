package com.mia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mia.DBManager;
import com.mia.vo.BoardVO;

public class BoardDAO {
	
	public BoardDAO() {
	}
	
	public static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		
		return instance;
	}

	public List<BoardVO> selectAllBoards(){
		
		String sql = "select * from article order by num desc";
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String id="mia";
		String password="mia";
		
		try {
			
			Class.forName(driver);
			conn=DriverManager.getConnection(url, id, password);
			
			//conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				BoardVO vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setContent(rs.getString("content"));
				vo.setWriteDate(rs.getDate("writeDate"));
				vo.setHits(rs.getInt("hits"));
				vo.setRecommand(rs.getInt("recommand"));
				
				list.add(vo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return list;
	}
}
