package com.kh.mb.member.model.service;

import com.kh.mb.member.model.exception.InsertFailException;
import com.kh.mb.member.model.exception.LoginFailException;
import com.kh.mb.member.model.vo.Member;

public interface MemberService {
	// 로그인용 메소드
	
	/* interface 안에는 전부 public abstract로 작성하기 때문에 생략 가능
		public abstract Member selectMember(Member m); */
	
	Member selectMember(Member m) throws LoginFailException;

	// 회원 가입용 메소드
	// exception 처리해서 넘길거라 리턴값이 없음(void)
	void insertMember(Member m) throws InsertFailException;

}
