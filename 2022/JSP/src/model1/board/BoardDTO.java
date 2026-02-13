package model1.board;

public class BoardDTO {
	//멤버변수는 무조건 있어야
	private String num;	//JavaBeans 규약에 따라 private로 
	private String title;
	private String content;
	private String id;
	private java.sql.Date postdate; 
	private String visitcount;
	private String name; 	//member테이블과 조인 후 회원이름을 출력해야할 때 사용
	
	
	//생성자 : 필요한 경우에만 생성. (필요X 시 생성 X)
	//setter/getter는 무조건 생성
	public String getnum() {
		return num;
	}
	public void setnum(String num) {
		this.num = num;
	}
	public String gettitle() {
		return title;
	}
	public void settitle(String title) {
		this.title = title;
	}
	public String getcontent() {
		return content;
	}
	public void setcontent(String content) {
		this.content = content;
	}
	public String getid() {
		return id;
	}
	public void setid(String id) {
		this.id = id;
	}
	public java.sql.Date getPostdate() {
		return postdate;
	}
	public void setPostdate(java.sql.Date postdate) {
		this.postdate = postdate;
	}
	//	public String getPOSTDATE() {
//		return POSTDATE;
//	}
//	public void setPOSTDATE(String pOSTDATE) {
//		POSTDATE = pOSTDATE;
//	}
	public String getvisitcount() {
		return visitcount;
	}
	public void setvisitcount(String visitcount) {
		this.visitcount = visitcount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
