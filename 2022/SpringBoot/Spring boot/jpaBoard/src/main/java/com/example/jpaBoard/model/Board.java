package com.example.jpaBoard.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="boardJpa") // table 생성 
@SequenceGenerator( name = "BOARD_SEQ_GENERATOR",
					sequenceName = "SEQ_BOARD",
					initialValue = 1,  //초기값 
					allocationSize = 1 // 시퀀스의 기본 allocationSize는 50, 번호가 50부터 생기므로 1으로 변경
				  )

public class Board {
	// [Primary Key]로 지정할 컬럼 -> @Id
	
	// MySQL이면 다음과 같이 기술
//	@Id
//	@GeneratedValue
//	@Column(length = 10)
//	protected Integer id;
	
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, 
					 generator="BOARD_SEQ_GENERATOR"
					 ) 						//자동 증가시킬 것 
	@Column(length = 10)
	protected Integer id;
	
	@Column(length = 30, nullable = false)
	protected String  name;
	
	@Column(length = 30, nullable = false)
	protected String  pwd;
	
	@Column(length = 500, nullable = false)
	protected String  title;
	
	@Column(length = 4000, nullable = false)
	protected String  content;
	
	// 날짜 기본형식 time, day, month, year 형태 저장 
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	protected Date 	  reg_date;
	
	@Column(length = 10, nullable = false)
	protected Integer read_count;
	
	// 답변인 경우, 어떤 글의 답변인지에 대한 상위 글 번호 
	// 최상위 글인 경우, 자신의 글 번호 동일 
	// 리스트보기에서 정렬 시 우선적으로 reply로 정렬 
	@Column(length = 10, nullable = false)
	protected Integer reply = 0;
	
	// 글 아래 모든 답변들에 대해 reply_level과 관계없이 1씩 증가시킬 것.
	@Column(length = 4000, nullable = false)
	protected Integer reply_step;
	
	// 1, 2차 답변글인지에 대한 여부
	// 하나의 글에 답변이 2개면 reply_level이 같다.
	// 리스트 보기에서 reply_level에 따라 들여쓰기를 한다. 
	@Column(length = 4000, nullable = false)
	protected Integer reply_level;
}
