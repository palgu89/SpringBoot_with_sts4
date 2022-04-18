package com.myweb.board.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@MappedSuperclass	// 밑에 생성되는거 다 매핑 시킬 거야(component scanning)
@EntityListeners(value = {AuditingEntityListener.class})	// AuditingEntityListener는 최상위 객체, @EntityListeners는 세팅해주는 애
@Getter
abstract class TimeBased {	// 추상클래스로 만든 이유 > 무조건 적용시키기 위해
	
	@CreatedDate
	@Column(name = "reg_at", updatable = false)	// db 생성시 컬럼 이름. 별도로 지정하고 싶지 않고, 문제가 없으면 name 안해도 됨. board class 참고
	private LocalDateTime regAt;
	
	@LastModifiedDate
	@Column(name = "mod_at")	// 수정이 계속 되어야 하니까
	private LocalDateTime modAt;
}
