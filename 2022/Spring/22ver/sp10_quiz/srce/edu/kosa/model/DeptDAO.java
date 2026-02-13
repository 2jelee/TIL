package edu.kosa.model;

import java.util.List;

public interface DeptDAO { 
	public List listDept();  			    // select 
	public void insertDept(DeptDTO dto);   	// insert
	public void updateDept(DeptDTO dto);	// update
	public void deleteDept(DeptDTO dto);	// delete 
}
