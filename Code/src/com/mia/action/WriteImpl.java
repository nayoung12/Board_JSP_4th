package com.mia.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mia.BbsInterface;
import com.mia.MvcProcessor;
import com.mia.vo.BoardVO;

public class WriteImpl implements BbsInterface{

	@Override
	public String handling(HttpServletRequest request, HttpServletResponse response) {
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardVO boardVo = new BoardVO();
		boardVo.setWriter(writer);
		boardVo.setTitle(title);
		boardVo.setContent(content);
		
		MvcProcessor mvcProcessor = MvcProcessor.getInstance();
		mvcProcessor.writeArticle(writer, title, content);
		//mvcProcessor.writeArticle(boardVo);

		return "list.do";
		
		/*
		 * BoardBean boardBean = new BoardBean();


		try {

			MultipartRequest multi = null;

			

			// 전송을 담당할 콤포넌트를 생성하고 파일을 전송한다.

			// 전송할 파일명을 가지고 있는 객체, 서버상의 절대경로, 최대 업로드 파일 크기, 인코딩 타입

			multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());


			boardBean.setId((String)request.getSession().getAttribute("id"));

			System.out.println(boardBean.getId());

			boardBean.setTitle(multi.getParameter("title"));

			System.out.println(boardBean.getTitle());

			boardBean.setContent(multi.getParameter("content"));

			System.out.println(boardBean.getContent());

			boardBean.setPassword(multi.getParameter("password"));

			System.out.println(boardBean.getPassword());

			boardBean.setFileName(multi.getOriginalFileName("fileName"));

			System.out.println(boardBean.getFileName());

			

		} catch(IOException ioe) {

			System.out.println(ioe);

		} catch(Exception ex) {

			System.out.println(ex);

		}


		MvcProcessor mvcProcessor = MvcProcessor.getInstance();

		mvcProcessor.setArticle(boardBean);


		
		 */
	}

}
