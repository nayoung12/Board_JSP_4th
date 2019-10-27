package com.mia.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mia.BbsInterface;
import com.mia.MvcProcessor;
import com.mia.vo.BoardVO;

public class ListAdminImpl implements BbsInterface{

	@Override
	public String handling(HttpServletRequest request, HttpServletResponse response) {

		List<BoardVO> articleList = null;
		MvcProcessor mvcProcessor = MvcProcessor.getInstance();	
		articleList = null;

		articleList = mvcProcessor.getArticles();
		request.setAttribute("articleList", articleList);

		return "list_admin.jsp";
	}
}
