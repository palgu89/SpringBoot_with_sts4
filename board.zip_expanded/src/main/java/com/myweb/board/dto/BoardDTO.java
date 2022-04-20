package com.myweb.board.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("bdto")
public class BoardDTO {
	private Long pno;
	private String title;
	private String writer;
	private String content;
	private String regAt;
	private String modAt;
	private Long readcount;
}
