package com.kh.mb.board.model.service;

import java.util.ArrayList;

import com.kh.mb.board.model.exception.BoardSelectListException;
import com.kh.mb.board.model.vo.Board;
import com.kh.mb.board.model.vo.PageInfo;

public interface BoardService {
	
	// 전체 게시물 수 조회용 메소드
	int getListCount() throws BoardSelectListException;

	// 페이징 처리 된 게시물 목록 조회용 메소드
	ArrayList<Board> selectBoardList(PageInfo pi) throws BoardSelectListException;

}
