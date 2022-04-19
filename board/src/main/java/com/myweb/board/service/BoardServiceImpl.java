package com.myweb.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myweb.board.dto.BoardDTO;
import com.myweb.board.repository.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	private final BoardMapper mapper;

	@Override
	public void register(BoardDTO bdto) throws Exception {
		mapper.insert(bdto);
	}

	@Override
	public List<BoardDTO> getList() throws Exception {
		return mapper.selectList();
	}
	
	// @Transactional
	@Override
	public BoardDTO getDetail(long pno) throws Exception {
		mapper.updateRC(pno);
		return mapper.selectOne(pno);
	}

	@Override
	public void modify(BoardDTO bdto) throws Exception {
		mapper.update(bdto);
	}

	@Override
	public void remove(long pno) throws Exception {
		mapper.delete(pno);
	}
	
}
