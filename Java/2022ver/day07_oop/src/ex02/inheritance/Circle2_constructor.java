package ex02.inheritance;

/*
> Constructor(생성자) 함수
- 클래스명과 동일
- return 타입 X(void 조차 사용 X >> error는 발생하지 않지만 노란줄은 뜬다) ★★★
- 중복정의 가능(overload 가능 : 중복함수)
- default 생성자(constructor) 가지고 있다
	(단, 사용자가 생성자 함수를 재정의하면 디폴트 생성자 함수기능 상실)
- 멤버변수의 초기화 담당
*/
public class Circle2_constructor extends Point{
	private int r; 
	
	public Circle2_constructor() { //생성자함수	(클래스명과 동일)		>>단, 생성자함수는 상속 안됨
		x = y = 10;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}

	//재정의(overide)
	public String toString() {
		String str = "x : \t"+x+"\ty :" + y;
		return str;
	}
	
	//output method
	public void display() {
		//※※※super위치는 맨 첫줄※※※
		super.display();	//상속받은(extends Point) display메소드를 가져온다.
		System.out.print("Circle2_constructor의 출력문 > r : " + r + " x : " + x + " y : "+y);
	}
}
