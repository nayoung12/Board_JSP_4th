package com.mia.dao;

import java.util.ArrayList;
import java.util.List;

import com.mia.vo.BoardVO;

public class BoardDAO {
	
	private BoardDAO() {
	}
	
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		
		return instance;
	}

	public List<BoardVO> selectAllBoards(){
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		return list;
	}
}
