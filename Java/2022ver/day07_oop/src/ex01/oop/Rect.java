package ex01.oop;
 
public class Rect { 
	//멤버변수
	private int x, y, x2, y2;
	 
	public int getX() {
		return x;
	}
 
	public void setX(int x) {
		this.x = x;
	}
 
	public int getY() {
		return y;
	}
 
	public void setY(int y) {
		this.y = y;
	} 
 
	public int getX2() {
		return x2;
	}
 
	public void setX2(int x2) {
		this.x2 = x2;
	}
 
	public int getY2() {
		return y2;
	}
 
	public void setY2(int y2) {
		this.y2 = y2;
	}
 
	//output method
	public void display() {
		System.out.println("x : " + x + "\ty : " + y + "\tx2 : " + x2 + "\ty2 : " + y2);
	}
}//end of Rect class 
