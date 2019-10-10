package com.mia.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mia.BbsInterface;
import com.mia.vo.BoardVO;

public class ListImpl implements BbsInterface{

	@Override
	public String handling(HttpServletRequest request, HttpServletResponse response) {

		Vector<BoardVO> articleList = null;
		MvcProcessor mvcProcessor = MvcProcessor.getInstance();	
		articleList = null;

		request.setAttribute("articleList", articleList);

		return "list.jsp";
	}
}
