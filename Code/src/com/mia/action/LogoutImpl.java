package com.mia.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mia.BbsInterface;
import com.mia.MvcProcessor;

public class LogoutImpl implements BbsInterface{

	@Override
	public String handling(HttpServletRequest request, HttpServletResponse response) {
		
		MvcProcessor mvcProcessor = MvcProcessor.getInstance();
		mvcProcessor.logout();
		
		return "main.jsp";
	}

}
