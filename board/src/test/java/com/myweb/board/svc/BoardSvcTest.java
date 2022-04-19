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
	public void registerTest() throws Exception {
		for(int i=0; i<1000; i++) {
			BoardDTO bdto = new BoardDTO();
			bdto.setTitle("This is Title of " + i);
			bdto.setContent("This Content of " + i);
			bdto.setWriter("Tester" + i + "@tester.com");
			bsv.register(bdto);
		}
	}
}
