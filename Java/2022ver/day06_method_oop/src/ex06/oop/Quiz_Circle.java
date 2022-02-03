package ex06.oop;

/*
[클래스 설계]
1. class Circle {x, y, r}
2. class Rect {x, y, x2, y2}

[문제1] class Sawn {
			이름, 직급, 부서, 급여, 연락처
			setter / getter method
			output method
*/

class Circle { 
	//멤버변수
	int x, y, r;

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

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}
	
	public void display() {
		System.out.println("x : "+x+" / y : "+y+" / r :"+r);
	}
}//end of Circle class

public class Quiz_Circle {
	public static void main(String[] args) {
		Circle cir = new Circle(); 
		
		cir.setX(0);
		cir.setY(1);
		cir.setR(2);
		cir.display();
	}
}  

