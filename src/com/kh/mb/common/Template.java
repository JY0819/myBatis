package com.kh.mb.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class Template {
	public static SqlSession getSqlSession() {
		SqlSession session = null;
		
		try {
			InputStream stream = Resources.getResourceAsStream("resources/mybatis-config.xml");
			System.out.println(stream);
			
			session = new SqlSessionFactoryBuilder().build(stream).openSession(false);
			System.out.println(session);
			// session이 성공적으로 만들어지면 connection이 생성된 것
			// openSession(false) jdbc의 connection 오토커밋 방지
			// mybatis-config.xml 에서 하는건 mybatis의 오토커밋 방지 : <transactionManager type="JDBC" />

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return session;
	}

}
