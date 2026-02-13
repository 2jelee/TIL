package ex07_ObjectOrientedProgramming2;

class InnerClass02 {
	class InstanceInner { };
	static class StaticInner { };
	
	// 같은 타입?의 멤버 간에는 서로 직접 접근이 가능
	InstanceInner iv = new InstanceInner();
	StaticInner cv = new StaticInner();
	
	static void staticMethod() {
		// static 멤버는 인스턴스에 접근 X
//		InstanceInner obj1 = new InstanceInner(); => static 멤버이므로 인스턴스에 접근 X
		StaticInner obj2 = new StaticInner(); //OK
		
		// 굳이 접근하기 위해서는 객체를 생성해야 한다. 인스턴스 클래스는 외부 클래스를 먼저 생성해야만 생성 가능
		InnerClass02 outer = new InnerClass02(); // 1. 외부클래스 생성
		InstanceInner obj1 = outer.new InstanceInner(); //2. 외부클래스를 통해 객체 생성
	}
	
	// instance 메소드는 static 멤버에도 접근 가능
	void instanceMethod() {
		InstanceInner obj1 = new InstanceInner();
		StaticInner obj2 = new StaticInner(); //OK
		
		//단, 메서드 내에 지역적으로 선언된 내부 클래스는 외부에서 접근 X
//		LocalInner lv = new LocalInner();
	}
	
	void myMethod() {
		class LocalInner { }
		LocalInner lv = new LocalInner();
	}
}
