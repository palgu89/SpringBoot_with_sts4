package com.myweb.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.board.dto.BoardDTO;
import com.myweb.board.repository.BoardMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper mapper;
	@Override
	public void register(BoardDTO bdto) throws Exception {
		mapper.insert(bdto);
	}

}
