package com.kh.mb.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mb.member.model.exception.InsertFailException;
import com.kh.mb.member.model.service.MemberService;
import com.kh.mb.member.model.service.MemberServiceImpl;
import com.kh.mb.member.model.vo.Member;

@WebServlet("/minsert")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberInsertServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라메터로 넘어온 값을 변수에 저장
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String birthDay = request.getParameter("birthDay");
		int genderNumber = Integer.parseInt(request.getParameter("gender"));
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
	
		String gender = "";
		if (genderNumber == 1 || genderNumber == 3) {
			gender = "M";
		} else {
			gender = "F";
		}
		
		/*System.out.println(userId);
		System.out.println(userPwd);
		System.out.println(userName);
		System.out.println(email);
		System.out.println(birthDay);
		System.out.println(gender);
		System.out.println(phone);
		System.out.println(address);*/
		
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		m.setUserName(userName);
		m.setEmail(email);
		m.setBirthDay(birthDay);
		m.setGender(gender);
		m.setPhone(phone);
		m.setAddress(address);
		
		MemberService ms = new MemberServiceImpl();
		try {
			ms.insertMember(m);
			
			response.sendRedirect("index.jsp");
			
		} catch (InsertFailException e) {
			RequestDispatcher error = request.getRequestDispatcher("WEB-INF/classes/common/errorPage.jsp");
			request.setAttribute("message", e.getMessage());
			error.forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
