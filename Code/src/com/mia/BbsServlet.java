package com.mia;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BbsServlet extends HttpServlet{

	  private static final long serialVersionUID = 1L;

	  // [/xxxx.do], [xxxxImpl] 형태로 저장된다  
	  private Map<String, Object> commandMap = new HashMap<String, Object>();

	  @Override
	  public void init(ServletConfig config) throws ServletException {

		  // MvcProperty.properties 파일의 내용을 props에 저장시킨다
	      String props = config.getInitParameter("dbConfig");

	      Properties properties = new Properties();

	      try { 
	    	  properties.load(new StringReader(props));
	      } catch(IOException ioe) {
	            throw new ServletException(ioe);
	      }
	      
	      System.out.println("mia : properties = " + properties);
	      
	      Iterator<?> keyIter = properties.keySet().iterator();

	      while(keyIter.hasNext()) {

	    	  String command = (String)keyIter.next();
	          String className = properties.getProperty(command);

	          try {
	          
	        	  // 문자열 xxxxImpl을 실제 클래스로 쓸수 있도록 인스턴스화 시켜준다
	              Class<?> commandClass = Class.forName(className);
	              Object commandInstance = commandClass.newInstance();

	              commandMap.put(command, commandInstance);
	          } catch(ClassNotFoundException cnfe) {
	        	  cnfe.printStackTrace();
	          } catch (InstantiationException ie) {
	              ie.printStackTrace();
	          } catch (IllegalAccessException iae) {
	              iae.printStackTrace();
	          }
	      }
	 }

	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  handling(request, response);
	  }

	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      handling(request, response);
	  }

	  private void handling(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  String view = null;
		  BbsInterface bbsInterface = null;

	      try {      	
	    	  
	    	  request.setCharacterEncoding("utf-8");

	          // 요청 주소만 저장 
	          // ex)http://xxx.xxx.xxx/MVC_BBS/xxxx.do ==> /MVC_BBS/xxxx.do 
	          String command = request.getRequestURI();

	          if(command.indexOf(request.getContextPath()) == 0) {
	              // 위에서 저장한 /MVC_BBS/xxxx.do 에서 /xxxx.do만 잘라내서 다시 저장
	        	  command = command.substring(request.getContextPath().length());
	          }

	          // /xxxx.do에 해당하는 클래스, 즉 xxxxImpl 반환
	          bbsInterface = (BbsInterface)commandMap.get(command);

	          // handling()실행
	          // 모든 클래스는 BbsInterface를 구현했기 때문에 업캐스팅해서 실행 가능하다(다형성)
	          view = bbsInterface.handling(request, response);
	      } catch(Throwable e) {
	            throw new ServletException(e);
	      }

	      // 해당 클래스를 거쳐 반환된 view 페이지로 이동
	      RequestDispatcher dispatcher = request.getRequestDispatcher(view);
	      dispatcher.forward(request, response);
	 }
}

/*
https://ggoreb.tistory.com/42
	

후보
http://blog.naver.com/PostView.nhn?blogId=simpolor&logNo=220909599530&categoryNo=59&parentCategoryNo=0&viewDate=&currentPage=2&postListTopCurrentPage=1&from=search&userTopListOpen=true&userTopListCount=10&userTopListManageOpen=false&userTopListCurrentPage=2https://rwd337.tistory.com/39
https://rwd337.tistory.com/39
*/