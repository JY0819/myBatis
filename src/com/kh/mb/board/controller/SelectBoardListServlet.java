package com.kh.mb.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mb.board.model.exception.BoardSelectListException;
import com.kh.mb.board.model.service.BoardService;
import com.kh.mb.board.model.service.BoardServiceImpl;
import com.kh.mb.board.model.vo.Board;
import com.kh.mb.board.model.vo.PageInfo;
import com.kh.mb.common.Pagination;

@WebServlet("/selectList")
public class SelectBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectBoardListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 1;
		
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		BoardService bs = new BoardServiceImpl();
		
		try {
			int listCount = bs.getListCount();
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Board> list = bs.selectBoardList(pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/board/boardList.jsp");
			view.forward(request, response);
			
		} catch (BoardSelectListException e) {
			RequestDispatcher error = request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp");
			error.forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
