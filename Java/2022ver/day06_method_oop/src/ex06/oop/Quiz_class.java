package ex06.oop;

import java.io.ObjectInputStream.GetField;

/*
 * 
 */

//좌표점 찍을 class인 Point
class Point {
//	int x, y;	//멤버변수(class 변수 O. local 변수 X)		| 앞에 아무것도 안쓰면 default 접근지정자임 | local변수는 초기화 필요. 해당 예제는 초기화 필요 X
	private int x, y;	//멤버변수		| 앞에 아무것도 안쓰면 default 접근지정자임
	
	//멤버함수	getter/setter method
	public int getX() {
		return x;	//x값을 가지고 간다.	외부로!
	}
	public void setX(int xx) {
		x = xx;	//세팅
	}
	
//	/*
	//만약 Y로 바꿔야한다면?
	public int getY() {
		return y;
	}
	public void setY(int yy) {
		y = yy;
	}
//	*/
	
	// user method
	public void display() {
		System.out.println(x + ", " + y);		//같은 공간이므로 직접 접근 O
		System.out.println(getX() + ", " + getY());		//같은 공간이므로 직접 접근 O
	}
}

//public은 main method가 있는 곳에다만 쓴다.
public class Quiz_class {
	public static void main(String[] args) {
		Point pt = new Point();
		pt.display();
		
		pt.setX(90); pt.setY(80); 
		pt.display();
		
//		pt.x = 90; pt.y = 80;
//		System.out.println(pt.getX()+", "+ pt.getY());
		
	}
}

