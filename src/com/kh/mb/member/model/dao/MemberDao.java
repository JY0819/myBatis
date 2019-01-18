package com.kh.mb.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mb.member.model.exception.InsertFailException;
import com.kh.mb.member.model.exception.LoginFailException;
import com.kh.mb.member.model.vo.Member;

public class MemberDao {

	// 로그인용 메소드
	public Member selectMember(SqlSession session, Member m) throws LoginFailException {
		Member member = null;
		
		// Member 라는 namespace의 loginMember를 찾음, m = 파라메터로 넘길 값
		member = session.selectOne("Member.loginMember", m);
//		System.out.println(member);
		
		if(member == null) {
			session.close();
			throw new LoginFailException("로그인 실패");
		}
		
		return member;
	}

	// 회원 가입용 메소드
	public void insertMember(SqlSession session, Member m) throws InsertFailException{
		int result = session.insert("Member.insertMember", m);
		
		if (result <= 0) {
			session.rollback();
			session.close();
			
			throw new InsertFailException("회원 가입 실패");
		}
		
		System.out.println("회원 가입 완료!");
	}

}
