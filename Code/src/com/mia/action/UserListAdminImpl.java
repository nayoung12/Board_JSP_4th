package com.mia.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mia.BbsInterface;
import com.mia.MvcProcessor;
import com.mia.vo.UserVO;

public class UserListAdminImpl implements BbsInterface{

	@Override
	public String handling(HttpServletRequest request, HttpServletResponse response) {

		MvcProcessor mvcProcessor = MvcProcessor.getInstance();
		List<UserVO> userList = new ArrayList<UserVO>();
		userList=mvcProcessor.getUserList();
		
		request.setAttribute("userList", userList);
		
		return "usersList.jsp";
	}

}
