package com.kh.mb.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.mb.member.model.dao.MemberDao;
import com.kh.mb.member.model.exception.InsertFailException;
import com.kh.mb.member.model.exception.LoginFailException;
import com.kh.mb.member.model.vo.Member;
import static com.kh.mb.common.Template.*;

public class MemberServiceImpl implements MemberService {

	// 로그인 처리용 메소드
	@Override
	public Member selectMember(Member m) throws LoginFailException {
		SqlSession session = getSqlSession();
		
		Member member = new MemberDao().selectMember(session, m);
		
		session.close();
		
		return member;
	}

	// 회원 가입용 메소드
	@Override
	public void insertMember(Member m) throws InsertFailException{
		SqlSession session = getSqlSession();
		
		new MemberDao().insertMember(session, m);
		
		session.commit();
		session.close();
	}

}
