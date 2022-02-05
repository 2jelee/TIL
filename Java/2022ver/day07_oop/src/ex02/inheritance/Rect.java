package ex02.inheritance;

// subClass : 자손 클래스 <-> superClass : 부모 클래스

// Sub 클래스
public class Rect extends Point {
	private int r;

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}
	
	public void display() {
		System.out.print("x : " + x + "\ty : " + y + "\tr : " + r);
	}
	
	
}
