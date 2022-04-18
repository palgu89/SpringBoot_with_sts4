package com.myweb.board.service;

import java.util.List;

import com.myweb.board.dto.BoardDTO;
import com.myweb.board.entity.Board;

public interface BoardService {
	Long register(BoardDTO bdto);
	List<BoardDTO> getList();
	BoardDTO getDetail(Long bno);
	void remove(Long bno);
	Long modify(BoardDTO bdto);
	
	// java 8버전부터 추상메서드뿐만 아니라 default method라는 기본 메서드(실행 가능, 호출 대상)를 인터페이스에서 선언이 가능하다. 단, 내용을 바꿀 순 없음. 실행만 가능
	
	default Board convertDtoToEntity(BoardDTO bdto) {
		return Board.builder()
				.bno(bdto.getBno())
				.title(bdto.getTitle())
				.writer(bdto.getWriter())
				.content(bdto.getContent()).build();
	}
	
	default BoardDTO convertEntityToDto(Board board) {
		return BoardDTO.builder()
				.bno(board.getBno())
				.title(board.getTitle())
				.writer(board.getWriter())
				.content(board.getContent())
				.regAt(board.getRegAt())
				.modAt(board.getModAt()).build();
	}
}
