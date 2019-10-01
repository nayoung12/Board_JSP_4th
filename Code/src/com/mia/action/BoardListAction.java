package com.mia.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mia.Action;
import com.mia.dao.BoardDAO;
import com.mia.vo.BoardVO;

public class BoardListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/board/boardList.jsp";
		
		BoardDAO dao = BoardDAO.getInstance();
		
		List<BoardVO> list = dao.selectAllBoards();
		
		request.setAttribute("boardList", list);
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}
