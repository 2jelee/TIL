package edu.kosa.model;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class GuestDAOImpl implements GuestDAO {
	
	private JdbcTemplate  jdbcTemplate;  // DML - insert, update, delete, select
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {   // DI - setter method
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List listGuest() {   // select
		String sql = "SELECT * FROM GUESTBOOK ORDER BY NUM DESC";
		return jdbcTemplate.queryForList(sql);
	}

	@Override
	public void insertGuest(GuestDTO dto) {  // insert
		String sql ="INSERT INTO GUESTBOOK (NUM,NAME,EMAIL,HOME,CONTENTS) VALUES (?, ?, ?, ?, ?)";
		Object[] arr = { dto.getNum(), dto.getName(), dto.getEmail(), dto.getHome(), dto.getContents() };
		
		this.jdbcTemplate.update(sql, arr);
	}

}





