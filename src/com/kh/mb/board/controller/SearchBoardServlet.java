package com.kh.mb.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mb.board.model.exception.SearchBoardException;
import com.kh.mb.board.model.service.BoardService;
import com.kh.mb.board.model.service.BoardServiceImpl;
import com.kh.mb.board.model.vo.Board;
import com.kh.mb.board.model.vo.PageInfo;
import com.kh.mb.board.model.vo.SearchCondition;
import com.kh.mb.common.Pagination;

@WebServlet("/search")
public class SearchBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchBoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");
		
//		System.out.println(searchCondition);
//		System.out.println(searchValue);
		
		SearchCondition sc = new SearchCondition();
		if (searchCondition.equals("writer")) {
			sc.setWriter(searchValue);
		}
		if (searchCondition.equals("title")) {
			sc.setTitle(searchValue);
		}
		if (searchCondition.equals("content")) {
			sc.setContent(searchValue);
		}
		
		int currentPage = 1;
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
	
		BoardService bs = new BoardServiceImpl();
		
		try {
			int listCount = bs.getSearchResultListCount(sc);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Board> list = bs.selectSearchResultList(sc, pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			
			request.getRequestDispatcher("WEB-INF/views/board/boardList.jsp").forward(request, response);
			
		} catch (SearchBoardException e) {
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
