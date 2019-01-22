package com.kh.mb.board.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mb.board.model.exception.BoardSelectListException;
import com.kh.mb.board.model.exception.BoardSelectOneException;
import com.kh.mb.board.model.exception.SearchBoardException;
import com.kh.mb.board.model.vo.Board;
import com.kh.mb.board.model.vo.PageInfo;
import com.kh.mb.board.model.vo.SearchCondition;

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

	// 게시물 조회수 증가용 메소드
	public int updateCount(SqlSession session, int bid) throws BoardSelectOneException{
		int result = session.update("Board.updateBoardCount", bid);
		
		if (result <= 0) {
			session.rollback();
			session.close();
			throw new BoardSelectOneException("게시물 조회수 증가 실패!");
		}
		
		return result;
	}

	// 게시물 조회용 메소드
	public Board selectOneBoard(SqlSession session, int bid) throws BoardSelectOneException {
		Board b = null;
		
		b = session.selectOne("Board.selectBoardOne", bid);
		
		System.out.println(b);
		
		if (b == null) {
			session.close();
			throw new BoardSelectOneException("게시물 상세보기 실패!");
		}

		return b;
	}
	
	// 검색 결과 수 조회용 메소드
	public int getSearchResultListCount(SqlSession session, SearchCondition sc) throws SearchBoardException {
		int result = session.selectOne("Board.selectSearchResultCount", sc);
	
		if (result <= 0) {
			session.close();
			throw new SearchBoardException("검색 결과 카운트 조회 실패!");
		}
		
		return 0;
	}
	
	// 검색 결과 게시물 조회용 메소드
	public ArrayList<Board> selectSearchResultList(SqlSession session, SearchCondition sc, PageInfo pi) throws SearchBoardException {
		ArrayList<Board> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) session.selectList("Board.selectSearchResultList", sc, rowBounds);
		
		System.out.println(list);
		
		if (list == null) {
			throw new SearchBoardException("검색 결과 리스트 조회 실패!");
		}
		return list;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
