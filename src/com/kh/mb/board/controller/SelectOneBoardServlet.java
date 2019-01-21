package com.kh.mb.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mb.board.model.exception.BoardSelectOneException;
import com.kh.mb.board.model.service.BoardService;
import com.kh.mb.board.model.service.BoardServiceImpl;
import com.kh.mb.board.model.vo.Board;

@WebServlet("/selectOne")
public class SelectOneBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectOneBoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bid = Integer.parseInt(request.getParameter("bid"));
		System.out.println(bid);
		
		BoardService bs = new BoardServiceImpl();
		
		try {
			Board b = bs.selectOneBoard(bid);
			
			int rCount = 0;
			
			if (b.getReplyList() != null) {
				rCount = b.getReplyList().size();
			}
			
			request.setAttribute("b", b);
			request.setAttribute("rCount", rCount);
			
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/board/boardDetail.jsp");
			view.forward(request, response);
			
		} catch (BoardSelectOneException e) {
			RequestDispatcher error = request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp");
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
