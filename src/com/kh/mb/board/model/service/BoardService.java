package com.kh.mb.board.model.service;

import java.util.ArrayList;

import com.kh.mb.board.model.exception.BoardSelectListException;
import com.kh.mb.board.model.exception.BoardSelectOneException;
import com.kh.mb.board.model.exception.SearchBoardException;
import com.kh.mb.board.model.vo.Board;
import com.kh.mb.board.model.vo.PageInfo;
import com.kh.mb.board.model.vo.SearchCondition;

public interface BoardService {
	
	// 전체 게시물 수 조회용 메소드
	int getListCount() throws BoardSelectListException;

	// 페이징 처리 된 게시물 목록 조회용 메소드
	ArrayList<Board> selectBoardList(PageInfo pi) throws BoardSelectListException;

	// 게시판 상세보기용 메소드
	Board selectOneBoard(int bid) throws BoardSelectOneException;

	// 검색 결과 수 조회용 메소드
	int getSearchResultListCount(SearchCondition sc) throws SearchBoardException;

	// 검색 결과 게시물 조회용 메소드
	ArrayList<Board> selectSearchResultList(SearchCondition sc, PageInfo pi) throws SearchBoardException;

}
