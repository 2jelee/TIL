package ex05.instanceMethod;

/*
instance method : 객체 생성하고 사용해야 한다.(메모리 상에 할당이 되어야!!)

대부분 instance method 사용한다.
*/

class B {
	int x, y;
	
	//instacne method
	public void setData(int xx, int yy) {
		System.out.println(xx + ", " + yy);
	}
}//end of B class
	

public class MainEntry {
	public static void main(String[] args) {
		B b = new B();	//★★★객체 생성, 메모리에 할당, 생성자 함수 자동 호출
		b.setData(20, 50);
//		b.setData(3, 3);
	}
}
