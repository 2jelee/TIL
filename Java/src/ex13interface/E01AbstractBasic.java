package ex13interface;

/*
추상클래스1 : 추상메소드를 포함하지 않은 클래스
 */
abstract class AbsClass1 {	
	//int형으로 표현할수 있는 최대값을 반환하는 Wrapper클래스의 상수
	public static final int MAX_INT = Integer.MAX_VALUE;
		
	int instanceVar;
	static int staticVar;	
	
	void instanceMethod() {}	
	static void staticMethod() {}
}
class AbsClassChild1 extends AbsClass1 {
	//자식클래스에서 확장한 멤버변수와 메소드
	int newVar;	
	void newMethod() {}	
	/*
	추상메소드를 포함하지 않은 추상클래스를 상속하면 오버라이딩은
	강제사항이 아닌 선택사항이다. 즉 필요한 경우에만 오버라이딩한다.
	 */
	@Override
	void instanceMethod() {
		System.out.println("필요없다면 오버라이딩 하지 않아도 상관없다."); 
	}
}
/*
추상클래스2 : 추상메소드를 포함한 클래스
	추상메소드를 멤버로 포함한 클래스는 반드시 abstract로
	선언해야한다. 그렇지 않으면 에러가 발생한다. 
 */
abstract class AbsClass2 {
	abstract void absMethod(int number);
}
/*
위의 클래스를 상속하면 부모가 가진 추상메소드를 그대로 상속받게
되므로 해당 클래스도 abstract로 선언해야 한다. 
단, 이 경우에는 객체를 생성할 수 없으므로 부모의 추상메소드를
오버라이딩 하면 된다. 
 */
class AbsClassChild2 extends AbsClass2 {	
	@Override
	void absMethod(int number) {
		System.out.println("부모클래스에서 오버라이딩한 메소드로 없을땐 에러발생함.");		
	}	
	void newMethod() {
		System.out.println("자식클래스에서 새롭게 확장한 메소드");
	}
}

public class E01AbstractBasic {

	public static void main(String[] args) {
		
		//추상클래스는 객체를 생성할 수 없다.
		//AbsClass1 absClass1 = new AbsClass1(); //=> 에러발생	
		
		//추상클래스를 상속한 하위클래스는 객체생성이 가능하다.
		AbsClassChild1 absClassChild1 = new AbsClassChild1();
				
		/*
		추상클래스로 인스턴스 생성은 할수없지만, 참조변수로 
		사용하는것은 가능하다. 
		 */
		AbsClass2 absClass2 = new AbsClassChild2();
		absClass2.absMethod(100);
		((AbsClassChild2)absClass2).newMethod();/*
			부모타입의 참조변수로 자식객체에 접근하려면 다운캐스팅후
			접근해야 한다. 
		 */
		
		/*
		추상클래스내에 선언된 정적멤버는 오버라이딩의 대상이
		아니므로, static이 가진 기본규칙을 따른다. 즉 클래스명으로
		접근하면 된다. 
		 */
		AbsClass1.staticMethod();
		AbsClassChild1.staticMethod();
	}
}


