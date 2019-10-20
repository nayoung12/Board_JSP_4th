package com.mia.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mia.BbsInterface;
import com.mia.MvcProcessor;
import com.mia.vo.BoardVO;

public class ReadImpl implements BbsInterface{

	@Override
	public String handling(HttpServletRequest request, HttpServletResponse response) {
	
		String num = request.getParameter("num");
		BoardVO article = null;
		MvcProcessor mvcProcessor = MvcProcessor.getInstance();
		
		article = mvcProcessor.getArticle(Integer.parseInt(num));
		request.setAttribute("article", article);
		
		return "article.jsp";
	}
}
