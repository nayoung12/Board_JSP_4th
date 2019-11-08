package com.mia.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mia.BbsInterface;
import com.mia.MvcProcessor;
import com.mia.vo.BoardVO;

public class ModifyFormImpl implements BbsInterface{

	@Override
	public String handling(HttpServletRequest request, HttpServletResponse response) {
		
		MvcProcessor mvcProcessor = MvcProcessor.getInstance();
		
		String num = request.getParameter("num");
		BoardVO article = mvcProcessor.getArticle(Integer.parseInt(num));
		
		request.setAttribute("article", article);
		
		return "modifyForm.jsp";
	}
}
