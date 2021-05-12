package model;

import java.sql.Date;

public class MemberDTO { //멤버테이블 [열]의 column_name과 같게
	//멤버변수
	private String id;
	private String pass;
	private String name;
	private java.sql.Date regidate;
	
	public MemberDTO() {} //기본생성자
	
	//생성자를 만들면 기본생성자 안만들어지므로 기본생성자 만들기
	//인자생성자 (자동완성)
	public MemberDTO(String id, String pass, String name, Date regidate) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.regidate = regidate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public java.sql.Date getRegidate() {
		return regidate;
	}

	public void setRegidate(java.sql.Date regidate) {
		this.regidate = regidate;
	}
	
}
