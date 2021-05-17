package model;

public class BoardDTO {
	//멤버변수는 무조건 있어야
	private String NUM;	//JavaBeans 규약에 따라 private로 
	private String TITLE;
	private String CONTENT;
	private String ID;
	private String POSTDATE; 
	private String VISITCOUNT;
	
	//생성자 : 필요한 경우에만 생성. (필요X 시 생성 X)
	//setter/getter는 무조건 생성
	public String getNUM() {
		return NUM;
	}
	public void setNUM(String nUM) {
		NUM = nUM;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public String getCONTENT() {
		return CONTENT;
	}
	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPOSTDATE() {
		return POSTDATE;
	}
	public void setPOSTDATE(String pOSTDATE) {
		POSTDATE = pOSTDATE;
	}
	public String getVISITCOUNT() {
		return VISITCOUNT;
	}
	public void setVISITCOUNT(String vISITCOUNT) {
		VISITCOUNT = vISITCOUNT;
	}
	
}
