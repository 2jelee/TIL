package edu.kosa.model;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class DeptDAOImpl implements DeptDAO {
	
	private JdbcTemplate  jdbcTemplate;  // DML - insert, update, delete, select
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {   // DI - setter method
		this.jdbcTemplate = jdbcTemplate;
	} 
	
	@Override
	public List listDept() { 
		String sql = "SELECT * FROM dept2 ORDER BY dcode DESC";
		return jdbcTemplate.queryForList(sql);
	}

	@Override
	public void insertDept(DeptDTO dto) {
		String sql ="INSERT INTO dept2 (dcode, dname, pdept, area) VALUES (?, ?, ?, ?)";
		Object[] arr = { dto.getDcode(), dto.getDname(), dto.getPdept(), dto.getArea() };
		
		this.jdbcTemplate.update(sql, arr); 
	}

	@Override
	public void updateDept(DeptDTO dto) {
		String sql ="UPDATE dept2 SET (dcode, dname, pdept) = (?, ?, ?) WHERE area = '서울지사' ";
		Object[] arr = { dto.getDcode(), dto.getDname(), dto.getPdept(), dto.getArea() };
		
		this.jdbcTemplate.update(sql, arr);   
	}

	@Override
	public void deleteDept(DeptDTO dto) { 
		String sql ="DELETE from dept2 WHERE decode = ? ";
		Object[] arr = { dto.getDcode() };
		
		this.jdbcTemplate.update(sql, arr); 
	}

}





