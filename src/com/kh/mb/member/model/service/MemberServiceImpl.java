package com.kh.mb.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.mb.member.model.dao.MemberDao;
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

}
