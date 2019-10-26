package com.mia.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mia.BbsInterface;
import com.mia.MvcProcessor;

public class LoginImpl implements BbsInterface{

	@Override
	public String handling(HttpServletRequest request, HttpServletResponse response) {
		
		String id=request.getParameter("ids");
		String password = request.getParameter("passwd");
		
		// 값 validation은 jsp단에서 아니면 java단에서? 
		
		MvcProcessor mvcProcessor = MvcProcessor.getInstance();
		int result=mvcProcessor.login(id, password);
		
		if(result!=0) {
			HttpSession session=request.getSession();
			session.setAttribute("userId", id);
			return "list.do";
		}else {
			return "main.jsp";
		}
	}

}
