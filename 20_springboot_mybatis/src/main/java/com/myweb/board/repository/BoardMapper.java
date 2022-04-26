package com.myweb.board.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myweb.board.dto.BoardDTO;

@Mapper	// mapper의 <mapper namespace="com.myweb.board.repository.BoardMapper">와 연동시켜주는 어노테이션
public interface BoardMapper {
	void insert(BoardDTO bdto) throws Exception;	// 원래 throws를 붙여주는게 정석(예전것도)
	List<BoardDTO> selectList() throws Exception;
	BoardDTO selectOne(Long pno) throws Exception;
	void update(BoardDTO bdto) throws Exception;
	void delete(Long pno) throws Exception;
	void updateRC(Long pno) throws Exception;
}
