package com.myweb.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder	// 클래스 자체를 접근해서 쉽게 접근 가능하도록 new를 하지 않고 객체화 시킬 수 있는 어노테이션
// Board board = new Board() -> Board.getBno().build()
public class Board extends TimeBased{	// board라는 테이블을 생성해서 아래의 컬럼을 생성함.
	
	@Id	// pk 설정 어노테이션
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// auto_increment
	private Long bno;	// boot는 기초자료형을 잘 쓰지 않음. 레퍼런스 타입(객체 타입)을 쓺. 이유는 db에서 연동 될 떄 jpa가 대부분 리턴을 레퍼런스타입으로 하기 때문에
	
	@Column(length = 100, nullable = false)
	private String title;
	
	@Column(length = 50, nullable = false)
	private String writer;
	
	@Column(length = 2000, nullable = false)
	private String content;
}
