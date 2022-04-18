package com.myweb.board.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.myweb.board.dto.BoardDTO;
import com.myweb.board.entity.Board;
import com.myweb.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor	// inject나 autowired를 안 할 수 있음. autowired 해도 되나, 이걸 더 선호하는거 같음(불필요한 자유성 차단?)
public class BoardServiceImpl implements BoardService {
	
	private final BoardRepository repository;	// 얘를 무조건 선언해 줌. final을 써야 함 안쓰면 에러
	
	@Override
	public Long register(BoardDTO bdto) {
		log.info(">>> {}", bdto);
		return repository.save(convertDtoToEntity(bdto)).getBno();	// 여기다 메서드까지 만들어도 되긴 하는데 너무 복잡해지니까 service에 만들겠음
		// Long 타입으로 만들어야 하니까 getBno()를 붙여서 Long으로 만들겠음
		
		// return repository.save(bdto);
		// boot는 jpa를 쓰는데 jpa는 자바로 만들어진 데이터 접근 방법 -> 그냥 객체를 던지면(dto) 풀어서 자동으로 해주는 게 아님 -> dto를 Board.java(entity 타입)로 바꿔줘야 함(java -> db 직접 연결)
		// dto를 entity 타입으로 바꾸는 구축을 해야 함(기존의 mapper에 #{})
	}

	@Override
	public List<BoardDTO> getList() {
		List<Board> list = repository.findAll();	// jpa의 추상메서드 findAll은 List<Board>로 준다. entity를 리턴해준다는 소린데 우리는 controller에 dto를 주기로 했다. -> list(entity)를 for로 분해해서 dto로 바꿔주자
		List<BoardDTO> dtoList = new ArrayList<>();	// dto 빈 list
		
		for (Board board : list) {
			dtoList.add(convertEntityToDto(board));	// service에서 entity -> dto 변환 후 더해줌
		}
		return dtoList;
	}

	@Override
	public BoardDTO getDetail(Long bno) {
		Optional<Board> option = repository.findById(bno);	// jpa의 추상메서드 findById = 기존 selectOne 기능 > optional로 반환해주는데 optional은 안 내용이 null인지 아닌지를 판단해줌
		return option.isPresent() ? convertEntityToDto(option.get()) : null;	// 보드가 존재하냐 ? option 안의 값을 get해서 entity -> dto : null;
	}

	@Override
	public void remove(Long bno) {
		repository.deleteById(bno);
	}

	@Override
	public Long modify(BoardDTO bdto) {
		// insert도 save, update도 save를 쓴다.
		// 단, register와는 달리 일단 db에 존재하는 번호인지를 검사한다. > 있으면 담아와서 꺼낸 뒤 변경하고 다시 save > update 기능이 되는 것임
		Optional<Board> board = repository.findById(bdto.getBno());
		if(board.isPresent()) {
			Board entity = board.get();
			entity.setTitle(bdto.getTitle());
			entity.setContent(bdto.getContent());
			return repository.save(entity).getBno();	// entity에 bno가 있으면 update
		}
		return null;
	}
}
