package ex01.oop;

//좌표점을 찍는 class
public class Point {
	private int x,y;	//멤버변수 - 좌표

	//private로 getter/setter 생성
	//return타입이 있는 것은 반드시 위에 멤버메소드에 void가 아니라, 자료형이 와야한다.
	public int getX() {	//아래 리턴 있다 >> 자료형 와야함
		return x;	
	}

	public void setX(int x) {	//return타입 없으니 void
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	//재정의(overide)
	/*
	//직접타이핑
	public String toString() {
		String str = "x : \t"+x+"\ty :" + y;
		return str;
	}
	*/
	
	//자동 완성		toString은 Object 클래스임
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
	
	
	//output method
	public void display() {
		System.out.println("x : " + x + "\ty : " + y);
	}

}
