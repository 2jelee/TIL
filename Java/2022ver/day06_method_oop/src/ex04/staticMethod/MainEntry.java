package ex04.staticMethod;

/*
static method : 객체 생성없이 바로 사용 가능
	[호출방법 2가지]
	1. object.methodName();
	2. ClassName.methodName();
*/

// class끼리 직접 넘나들면 X  >>  객체를 생성해서 들어가야 한다.

class A{
	int x, y; //접근지정자
//	private int x, y;	//접근지정자를 private하게 만듦.
	
	// ★★★ static method ★★★
	public static void setData(int xx, int yy) {
		System.out.println(xx + ", " + yy);
	}
} //A class End

public class MainEntry {
	public static void main(String[] args) {
		A obj = new A(); //★★★객체 생성, 메모리에 할당, 생성자 함수 자동 호출		여기서 obj는 object instance. (변수와 같다)
		obj.x = 9;
		System.out.println(obj.x);
		
//		obj.setData(3, 5);	//object.methodName();
		A.setData(10, 20); 	//ClassName.methodName();
	}
}
