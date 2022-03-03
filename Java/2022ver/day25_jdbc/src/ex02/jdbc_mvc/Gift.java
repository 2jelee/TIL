package ex02.jdbc_mvc;

// Model
public class Gift {
	
	// final이므로 변경 X
	public final String ClassName = "Gift";
	
	
	// 멤버변수 gno, gname, g_start, g_end => 오라클과 이름 같게 만들었음. (달라도 상관 X)
	private int gno;
	private String gname;
	private int g_start;
	private int g_end;
	
	//바꿀 일(set)이 없으므로 getter만
	public String getClassName() {
		return ClassName;
	}
	
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public int getG_start() {
		return g_start;
	}
	public void setG_start(int g_start) {
		this.g_start = g_start;
	}
	public int getG_end() {
		return g_end;
	}
	public void setG_end(int g_end) {
		this.g_end = g_end;
	}
	
	
}
