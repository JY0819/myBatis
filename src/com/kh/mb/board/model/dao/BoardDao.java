package com.kh.mb.board.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mb.board.model.exception.BoardSelectListException;
import com.kh.mb.board.model.vo.Board;
import com.kh.mb.board.model.vo.PageInfo;

public class BoardDao {

	// 전체 게시물 수 조회용 메소드
	public int getListCount(SqlSession session) throws BoardSelectListException {
		int result = session.selectOne("Board.selectListCount");
		
		System.out.println("전체 게시글 수 조회 > " + result);
		
		if (result <= 0) {
			session.close();
			throw new BoardSelectListException("게시글 수 조회 실패");
		}
		
		return result;
	}

	// 페이징 처리 된 게시물 목록 조회용 메소드
	public ArrayList<Board> selectBoardList(SqlSession session, PageInfo pi) throws BoardSelectListException {
		ArrayList<Board> list = null;
		
		// 몇개의 게시글을 건너 뛰고 조회를 할 지에 대해 계산한다.
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		// RowBounds : mybatis에서 제공하는 페이징 조회
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		// 조회라서 넘길 값이 없을 경우 null
		list = (ArrayList) session.selectList("Board.selectBoardList", null, rowBounds);
		
		System.out.println(list);
		
		if (list == null) {
			session.close();
			throw new BoardSelectListException("게시물 조회 실패");
		}
		
		return list;
	}

}
