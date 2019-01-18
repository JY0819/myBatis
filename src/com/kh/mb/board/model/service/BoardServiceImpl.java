package com.kh.mb.board.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.mb.board.model.dao.BoardDao;
import com.kh.mb.board.model.exception.BoardSelectListException;
import com.kh.mb.board.model.vo.Board;
import com.kh.mb.board.model.vo.PageInfo;

import static com.kh.mb.common.Template.*;

import java.util.ArrayList;

public class BoardServiceImpl implements BoardService {
	
	// 전체 게시물 수 조회용 메소드
	@Override
	public int getListCount() throws BoardSelectListException {
		SqlSession session = getSqlSession();
		
		int listCount = new BoardDao().getListCount(session);
		
		session.close();
		
		return listCount;
	}

	// 페이징 처리 된 게시물 목록 조회용 메소드
	@Override
	public ArrayList<Board> selectBoardList(PageInfo pi) throws BoardSelectListException {
		SqlSession session = getSqlSession();
		
		ArrayList<Board> list = new BoardDao().selectBoardList(session, pi);
		
		session.close();
		
		return list;
	}

}
