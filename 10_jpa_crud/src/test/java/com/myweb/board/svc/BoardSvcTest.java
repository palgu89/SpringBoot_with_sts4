package com.myweb.board.svc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.myweb.board.dto.BoardDTO;
import com.myweb.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class BoardSvcTest {
	
	@Autowired
	private BoardService bsv;
	
	@Test
	public void registerTest() {
		BoardDTO bdto = BoardDTO.builder().title("Board Title register Test").writer("Board Writer register Test").content("Board Content register Test").build();
		log.info(">>> {}", bsv.register(bdto));
	}
}
