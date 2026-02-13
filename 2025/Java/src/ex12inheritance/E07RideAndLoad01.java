package ex12inheritance;

/*
상속관계에서 오버로딩 VS 오버라이딩

오버로딩 : 함수명은 같으나 매개변수의 갯수, 타입, 순서가 다른
	경우를 말한다. 즉, 서로 다른 함수이므로 상속받은 하위클래스에서는
	오버로딩 된 모든 메소드가 포함된다. 
오버라이딩 : 함수명, 매개변수, 반환형까지 모두 동일한 함수를
	상속관계에서 있는 하위클래스에서 재정의 한것을 말한다. 
	이 경우 하위클래스에서 정의한 메소드가 상위클래스의 메소드를
	가리게 되므로, 항상 최하위 클래스에 메소드가 호출되게 된다. 
	즉, 오버라이딩은 참조변수의 타입에 영향을 받지 않는다. 
 */
class A {
	public void rideMethod() {
		System.out.println("A의 rideMethod");
	}
	public void loadMethod() {
		System.out.println("A의 loadMethod");
	}
}
class B extends A {
	@Override
	public void rideMethod() {
		System.out.println("B의 rideMethod");
	}
	public void loadMethod(int num) {
		System.out.println("B의 loadMethod");
	}
}
class C extends B {
	/*
	rideMethod()는 오버라이딩 처리된 메소드로
	상위클래스에서 정의된 반환형, 메소드명, 매개변수의 갯수가
	모두 동일하다. 
	 */
	@Override
	public void rideMethod() {
		System.out.println("C의 rideMethod");
	}
	/*
	loadMethod()는 오버로딩 처리된 메소드로
	상위클래스에 정의된 메소드와 매개변수의 갯수, 타입이 
	서로 다르다. 
	 */
	public void loadMethod(double num) {
		System.out.println("C의 loadMethod");
	}
	/*
	따라서 C클래스로 객체를 생성하면 오버라이딩된 메소드는 
	모두 가려지게 되어 C클래스에 정의된 메소드 하나만 남게된다. 
	오버로딩된 메소드는 서로 다르므로 3개 모두 존재한다. 
	 */
}
public class E07RideAndLoad01 {

	public static void main(String[] args) {

		/*
		부모타입의 참조변수로 자식객체를 참조할 수 있으므로
		아래 문장은 모두 성립한다. 
		 */
		A ref1 = new C();
		B ref2 = new C();
		C ref3 = new C();

		/*
		참조변수에 상관없이 항상 최하위에 오버라이딩 된 메소드가
		호출된다. 즉 아래 부분은 모두 C클래스에 생성된 rideMethod()
		메소드가 호출된다. 
		 */
		System.out.println("오버라이딩 처리된 메소드");
		ref1.rideMethod();// O 
		ref2.rideMethod();// O
		ref3.rideMethod();// O 

		/*
		ref3은 C타입의 참조변수로 해당 객체를 C객체라고 생각한다.
		따라서 접근범위는 전체가 되므로 아래 3개의 호출문장은 
		모두 실행된다. 
		 */
		System.out.println("오버로딩 처리된 메소드");
		ref3.loadMethod(); 
		ref3.loadMethod(1);  
		ref3.loadMethod(1.1); 
		
		//해당 객체를 B타입으로 간주하고 참조한다. 
		ref2.loadMethod();
		ref2.loadMethod(1); // -> B클래스까지만 접근 가능하다. 
		//ref2.loadMethod(1.1);// -> C클래스 영역은 접근불가
		
		//해당 객체를 A타입으로 간주하고 참조한다. 
		ref1.loadMethod(); // -> A클래스 영역까지만 접근 가능하다.
		//ref1.loadMethod(1);//접근불가
		//ref1.loadMethod(1.1);//접근불가
		
				
		////////////////////////////////////////////////////

		//부모 참조변수로 자식 객체를 참조할수 있다. 
		A refNum1 = new B(); //가능
		A refNum2 = new C(); //가능 
		B refNum3 = new C(); //가능 

		C refAddr1 = new C(); // C타입 = C타입 -> 가능
		B refAddr2 = refAddr1; // B타입 = C타입 -> 가능
		A refAddr3 = refAddr1; // A타입 = C타입 -> 가능  

		A refId1 = new C(); // A타입 = C타입 -> 가능 
		//B refId2 = refId1; // B타입 = A타입 -> 불가능(에러발생)
		//C refId3 = refId1; // C타입 = A타입 -> 불가능(에러발생)
		
		
		/*
		위에서 에러가 난 부분을 아래처럼 다운캐스팅(강제형변환)하면
		참조가 가능하다. 
		 */
		C refId3 = (C)refId1;
		/*		
		//참조] 기본자료형에서의 형변환
		int a = 10; //가능
		double b = 20.0; //가능
		double c = 11; //가능
		int d = (int)20.3; //불가능해서 int형으로 강제 형변환
		*/
	}
}




