package com.kh.mb.frontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.me")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberFrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		String uri = request.getRequestURI();
		System.out.println("요청 uri > " + uri);
		// 요청 uri > /mb/login.me
		
		
		// / + 1 : /의 다음 문자
		String action = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf(".me"));
		System.out.println("action > " + action);
		// action > login
		
		
		RequestDispatcher rd = null;
		switch(action) {
			case "login" : rd = request.getRequestDispatcher("login");		break;
			case "logout" : rd = request.getRequestDispatcher("logout"); 	break;
		}
		rd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
