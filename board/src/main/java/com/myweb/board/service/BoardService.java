package com.myweb.board.service;

import java.util.List;

import com.myweb.board.dto.BoardDTO;

public interface BoardService {
	void register(BoardDTO bdto) throws Exception;
	List<BoardDTO> getList() throws Exception;
	BoardDTO getDetail(long pno) throws Exception;
	void modify(BoardDTO bdto) throws Exception;
	void remove(long pno) throws Exception;
}
