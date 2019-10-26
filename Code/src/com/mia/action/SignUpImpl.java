package com.mia.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mia.BbsInterface;
import com.mia.MvcProcessor;

public class SignUpImpl implements BbsInterface{

	@Override
	public String handling(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("userId");
		String password = request.getParameter("passwd");
		String name = request.getParameter("userName");
		
		MvcProcessor mvcProcessor = MvcProcessor.getInstance();
		mvcProcessor.signUp(id, password, name);

		return "main.jsp";
	}
}
