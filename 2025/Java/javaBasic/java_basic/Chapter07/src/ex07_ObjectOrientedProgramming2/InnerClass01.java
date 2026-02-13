package ex07_ObjectOrientedProgramming2;

class InnerClass01 {
	class InstanceInner {
		int iv = 100;
//		static int cv = 100;  => error! static 변수 선언 X
		final static int CONST = 100; // final static = 상수이므로 OK
	}
	
	static class StaticInner{
		int iv = 200;
		static int cv = 200;  // static class만이 static member를 정의할 수 있다!
	}
	
	// 아우터 클래스의 메소드
	void myMethod() {
		class LocalInner{
			int iv = 300;
//			static int cv = 100; => error! static 변수 선언 X
			final static int CONST = 300;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(InstanceInner.CONST); // 결과 : 100
		System.out.println(StaticInner.cv);		 // 결과 : 200
	}
}
