package com.myweb.board.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myweb.board.dto.BoardDTO;

@Mapper
public interface BoardMapper {
	void insert(BoardDTO bdto) throws Exception;
	List<BoardDTO> selectList() throws Exception;
	BoardDTO selectOne(Long bno) throws Exception;
	void update(BoardDTO bdto) throws Exception;
	void delete(Long bno) throws Exception;
	void updateRC(Long bno) throws Exception;
}
