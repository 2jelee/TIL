package ex03.innerClass;
 
//외부클래스
class OuterClass {
	static int no;
	String message = "hi!";
	
	public void outerMethod() {
		System.out.println("outer method call~");
//		System.out.println(su);		//outer 클래스는 inner클래스의 멤버변수에 접근 불가능	>> 마치 상속처럼
	}
	
	//outer class 안에서 종속적인 형태로 어떠한 일을 할 때
	class InnerClass {	//내부클래스
		int su = 99;
		public void show() {
			System.out.println(su);	//내부(자신의 것) 사용 가능
			System.out.println(message); 	//외부클래스 멤버 사용 가능 	>> 마치 상속처럼
											//내부에 있는 것은 내부 뿐만 아니라 아우터 클래스의 멤버에 접근 또한 가능하다!
		}
		
		public void disp() {
			outerMethod(); 		//외부클래스 메소드 호출
		}
	}	//innerClass 
}

public class MainEntry {
	public static void main(String[] args) {
		//1. 
		OuterClass oc = new OuterClass();
		OuterClass.InnerClass inner = oc.new InnerClass();
		inner.disp();
		inner.show();
		System.out.println("===============================");
		
		//2.
		OuterClass.InnerClass ic = new OuterClass().new InnerClass();
		ic.show();
	}
}
