package com.mia.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mia.BbsInterface;

public class WriteFormImpl implements BbsInterface{

	@Override
	public String handling(HttpServletRequest request, HttpServletResponse response) {
		
		String state = "write_form.do";
		request.setAttribute("state", state);

		return "writeForm.jsp";
	}

	
}
