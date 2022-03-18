package ex07_ObjectOrientedProgramming2;

/*
 * [익명 클래스]
 * 클래스의 선언과 객체의 생성을 동시에 한다.
 * - 단 한번만 사용 O
 * - 오직 하나의 객체만을 생성할 수 있는 일회성 클래스 (단 하나의 클래스를 상속 받거나 / 단 하나의 인터페이스만 구현 O)
 */

class AnonymousClass {
	//익명 클래스 1
	Object iv = new Object() {
		void method() { }
	};
	
	//익명 클래스 2
	static Object cv = new Object() {
		void method() { }
	};
	
	//익명 클래스 3
	void myMethod() {
		Object lv = new Object() {
			void method() { }
		};
	}
}
