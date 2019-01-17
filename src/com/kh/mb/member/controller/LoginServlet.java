package com.kh.mb.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.mb.member.model.exception.LoginFailException;
import com.kh.mb.member.model.service.MemberService;
import com.kh.mb.member.model.service.MemberServiceImpl;
import com.kh.mb.member.model.vo.Member;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		System.out.println("userId > " + userId);
		System.out.println("userPwd > " + userPwd);
		
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		
		// 의존성 주입 : 클래스 간의 의존성을 줄여준다
		MemberService ms = new MemberServiceImpl();
		
		try {
			Member member = ms.selectMember(m);
			
			HttpSession session = request.getSession();
			
			session.setAttribute("loginUser", member);
			
			response.sendRedirect("index.jsp");
			
		} catch (LoginFailException e) {
			RequestDispatcher error = request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp");
			request.setAttribute("message", e.getMessage());
			error.forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
