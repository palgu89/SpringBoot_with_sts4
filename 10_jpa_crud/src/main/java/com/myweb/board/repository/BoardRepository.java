package com.myweb.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myweb.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {	// <db 만들 때 참고해야 할 type, 인스턴스화 됐을 때 Board의 일련번호(주소값) -> long 쓰면 됨>
	// 얘가 java와 db를 직접 연결 시켜준다. service에서 dto를 받아와서 entity로 바꿔준다음 repository에 던진다. 그럼 여기서 db로 던진다.
}
