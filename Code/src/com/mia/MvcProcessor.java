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
	private List<BoardVO> allArticles; // 굳이 전역 변수로 사용하면 좋은 이유가....?
	
	// 지역 변수로 여러번 선언하고 사라지는 것이 효율이 좋은가? 아니면 전역 변수로 한번 선언하고 계속 사용하는 것이 효율이 더 좋은가?
	
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
	
	public int login(String id, String password) {
		
		int result=0;
		
		try {			
			connection=getConnection();
			pstmt=connection.prepareStatement("SELECT * FROM USERS WHERE id=? and password=?");
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			
			if(rs.next() == true) {
				result = 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	public void logout() {
		 //session.invalidate();
	}
	
	public void signUp(String id, String password, String name) {

		try {
			
			connection=getConnection();
			pstmt=connection.prepareStatement("INSERT INTO USERS VALUES (?,?,?)");
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, name);
			pstmt.executeQuery();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
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
	
	public BoardVO getArticle(int num) {
		
		//BoardVO article = null; // 이 부분을 활용하면 article 부분에 null pointer access 발생해서 기능 제대
		BoardVO article = new BoardVO();
	
		try {

			connection = this.getConnection();
			pstmt=connection.prepareStatement("SELECT * FROM ARTICLE WHERE NUM=?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			
				article.setNum(rs.getInt("NUM"));
				article.setTitle(rs.getString("TITLE"));
				article.setContent(rs.getString("CONTENT"));
				article.setWriter(rs.getString("WRITER"));
				article.setWriteDate(rs.getDate("WRITEDATE"));
				article.setHits(rs.getInt("HITS"));
				article.setRecommand(rs.getInt("RECOMMAND"));
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
		
		return article;
	}
	
	public void writeArticle(String writer, String title, String content) {
		
		try {			
			connection = getConnection();
			// ARTICLE_sequence.nextval
			pstmt=connection.prepareStatement("INSERT INTO ARTICLE VALUES (?, ?, ?, ?, sysdate, 0, 0)");
			pstmt.setInt(1, 10);
			pstmt.setString(2, title);
			pstmt.setString(3, writer);
			pstmt.setString(4, content);
			int result=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
