package com.mia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mia.vo.BoardVO;

public class MvcProcessor {
	
	private static MvcProcessor instance = new MvcProcessor();
	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private List<BoardVO> allArticles;
	
	public static MvcProcessor getInstance() {
		return instance;
	}
	
	private Connection getConnection() throws ClassNotFoundException, SQLException{
	
		String driverName="oracle.jdbc.driver.OracleDriver";
		final String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
		final String dbID = "mia";
		final String dbPassword = "mia";
		
		Connection connection = null;
		Class.forName(driverName);
		connection = DriverManager.getConnection(dbUrl, dbID, dbPassword);
		
		System.out.println("오라클 DB 연결");
		
		return connection;
	}

	public int sampleTest() {
		
		int size=0;
		
		try {			
			connection = this.getConnection();
			pstmt=connection.prepareStatement("SELECT count(num) FROM ARTICLE");
			rs=pstmt.executeQuery();

			if(rs.next()) {
				size = rs.getInt(1);
			}
		}catch(Exception e) {
			
		}
		
		return size;
	}
	
	public List<BoardVO> getArticles() {

		allArticles = new ArrayList<BoardVO>();

		try {

			connection = this.getConnection();
			pstmt=connection.prepareStatement("SELECT * FROM ARTICLE order by NUM");
			rs = pstmt.executeQuery();

			while(rs.next()) {

				BoardVO boardVO = new BoardVO();		
				boardVO.setNum(rs.getInt("num"));		
				boardVO.setTitle(rs.getString("title"));		
				boardVO.setWriter(rs.getString("writer"));
				boardVO.setHits(rs.getInt("hits"));		
				boardVO.setRecommand(rs.getInt("recommand"));		
				boardVO.setWriteDate(rs.getDate("writeDate"));

				allArticles.add(boardVO);
			}

		} catch(Exception e) {
			e.printStackTrace();
		} finally {

			if(rs != null) {
				try {
					rs.close();
				} catch(Exception e) {}

			}

			if(pstmt != null) {
				try {
					pstmt.close();
				} catch(Exception e) {}

			}

			if(connection != null) {
				try {
					connection.close();
				} catch(Exception e) {}
			}
		}

		return allArticles;
	}
}
