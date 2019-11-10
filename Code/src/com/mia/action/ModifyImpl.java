package com.mia.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mia.BbsInterface;
import com.mia.MvcProcessor;

public class ModifyImpl implements BbsInterface{

	@Override
	public String handling(HttpServletRequest request, HttpServletResponse response) {
		
		String num = request.getParameter("num");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		MvcProcessor mvcProcessor = MvcProcessor.getInstance();
		mvcProcessor.modifyArticle(Integer.parseInt(num), title, content);
		
		return "list.do";
	}
}
