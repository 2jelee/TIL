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

class Rect { 
	//멤버변수
	int x, y, x2, y2;
	
	public void setData(int xx, int yy, int xx2, int yy2) {
		System.out.println(xx + ", " + yy + ", " + xx2 + ", " + yy2);
	}
}//end of Rect class
	

public class Quiz_Rec {
	public static void main(String[] args) {
		Rect rec = new Rect();	 
		rec.setData(1,2,3,4);
	}
}  

