package com.myweb.board.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDTO {
	private Long bno;
	private String title;
	private String writer;
	private String content;
	private LocalDateTime regAt, modAt;
}
