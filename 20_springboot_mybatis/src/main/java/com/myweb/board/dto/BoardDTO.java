package com.myweb.board.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("bdto")	// 여기에 적으면 mybatis-config.xml에 안적어도 됨? 일단은 mybatis-config.xml이 메인
public class BoardDTO {
	private Long pno;
	private String title;
	private String writer;
	private String content;
	private String regAt;
	private String modAt;
	private Long readcount;
}
