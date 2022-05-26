package com.example.jwtTest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@SequenceGenerator(name="USER_SEQ_GENERATOR",
					sequenceName = "SEQ_USR",
					initialValue=1,
					allocationSize = 1
					) //MySQL 사용에서는 이 부분 주석처리하고 필드에서 처리(자동증가)
				
public class UserTbl {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ_GENERATOR")
	private Long id;

	@Column(length = 100, nullable = false, unique = true)
	private String email;
	
	@Column(length = 300, nullable = false)
	private String password;
}
