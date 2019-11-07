package com.mia.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mia.BbsInterface;
import com.mia.MvcProcessor;

public class DeleteUserImpl implements BbsInterface{

	@Override
	public String handling(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		
		MvcProcessor mvcProcessor = MvcProcessor.getInstance();
		mvcProcessor.deleteUser(id);
		
		return "userList.jsp";
	}

}
