package edu.kosa.model;

import java.util.List;

public interface GuestDAO {
	
	public List listGuest();   // select 
	public void insertGuest(GuestDTO dto);   // insert
}
