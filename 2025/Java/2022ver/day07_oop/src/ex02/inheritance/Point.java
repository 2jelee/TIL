package ex02.inheritance;

public class Point {	//Super
	
//	private int x, y;	//자기 class 내부에서만 사용 가능
	protected int x, y;	//자기 class 내부에서만 사용 가능

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
	
	//생성자 - 중복정의 가능(overload 가능 : 중복함수)
	public Point() { //default 생성자
		x=y=20;
	}
	
	public Point(int x) {	//매개변수 1개짜리
		this.x = x;
		y = 9;
	}
	
	public Point(int x, int y) {	//매개변수 2개짜리
		this.x = x;
		this.y = y;
	}
	
	//output method
	public void display() {
		System.out.println("Point의 출력문 > x : " + x + "\ty : " + y);
	}
}
