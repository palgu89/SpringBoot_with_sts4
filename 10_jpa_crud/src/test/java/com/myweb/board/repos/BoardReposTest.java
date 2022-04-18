package com.myweb.board.repos;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.myweb.board.entity.Board;
import com.myweb.board.repository.BoardRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class BoardReposTest {
	@Autowired	// @Inject와 똑같은 것. 약간 차이가 있다
	private BoardRepository boardRepos;	// 컴포넌트화 시킴
	
	@Test
	public void insertDummyTest() {
		IntStream.rangeClosed(1, 1000).forEach(i->{	// i가 1부터 1000까지 돎
			Board board = Board.builder().title("This is TItle of " + i).content("This Content of " + i).writer("Tester" + i + "@tester.com").build();
			log.info(">>> {}", boardRepos.save(board));
			
			// 원래였으면
//			for(int j = 0; j < 1000; j++) {
//				Board board = new Board();
//				board.setTitle("This is Title of " + j);
//				board.setContent("This Content of " + j);
//				board.setWriter("Tester" + j + "@tester.com");
//				boardRepos.save(board);		// insert기능 -> jpa에서 기본적 crud 메서드가 존재하고 그중 save메서드 사용
//			}
			
		});
	}
}
