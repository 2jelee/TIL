package ex06;

/*
 * 실행 순서 : 클래스 초기화 블럭 -> main 메서드 -> 인스턴스 초기화 블럭 -> 생성자 수행
 * 
 * 클래스 초기화 블럭은 처음 메모리에 로딩될 때 한번만 수행된다.
 * 반면, 인스턴스 초기화 블럭은 인스턴스가 생성될 때마다 수행된다. ★★★
 */

class InitializationFlow {
	//클래스 초기화 블럭
	static {
		System.out.println("static { }"); // [순서 1] 클래스 초기화 블럭이 가장 먼저 수행
	}
	
	//인스턴스 초기화 블럭
	{
		System.out.println("{ }"); // [순서 3] main 메서드 다음으로 인스턴스 초기화 블럭 수행
	}
	
	//생성자
	public InitializationFlow() { 
		System.out.println("생성자");
	}

	public static void main(String[] args) {
		System.out.println("Initialization init = new Initialization(); "); // [순서 2] 클래스 초기화 블럭 다음으로 main 메서드 수행
		InitializationFlow init = new InitializationFlow();
		
		System.out.println("Initialization init2 = new Initialization(); ");
		InitializationFlow init2 = new InitializationFlow();
	}
}
