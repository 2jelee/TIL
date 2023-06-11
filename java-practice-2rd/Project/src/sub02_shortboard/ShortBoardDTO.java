package sub02_shortboard;

public class ShortBoardDTO {
	//멤버변수
	private String name;
	private String id;    
	private String pass;    
	private String phone; // 추가) 회원가입
	private String mail;	//21.06 프로젝트시 추가함
	private String address; // 추가) 회원가입
	
	private String num;
	private String bpass;    
    private String title;
    private String content;
    private java.sql.Date postdate;
    private String visitcount;
    //member테이블과 조인후 회원이름을 출력해야 할때 사용
    
    private String ofile;	//21.06.10 사진게시판용 추가(이하 3개) >> 추후 model2로 옮기기
	private String sfile; 
	private int downcount;
    
    
	
	//생성자 : 필요한 경우에만 생성한다.
    //setter/getter는 무조건 생성한다. 
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public java.sql.Date getPostdate() {
		return postdate;
	}
	public void setPostdate(java.sql.Date postdate) {
		this.postdate = postdate;
	}
	public String getVisitcount() {
		return visitcount;
	}
	public void setVisitcount(String visitcount) {
		this.visitcount = visitcount;
	}
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
	

    
    
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getBpass() {
		return bpass;
	}
	public void setBpass(String bpass) {
		this.bpass = bpass;
	}

	public String getOfile() {
		return ofile;
	}
	public void setOfile(String ofile) {
		this.ofile = ofile;
	}
	public String getSfile() {
		return sfile;
	}
	public void setSfile(String sfile) {
		this.sfile = sfile;
	}
	public int getDowncount() {
		return downcount;
	}
	public void setDowncount(int downcount) {
		this.downcount = downcount;
	}
}
