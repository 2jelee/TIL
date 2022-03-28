package ex08_Exception;

class MethodThrow01 {
	public static void main(String[] args) throws Exception {
		method1();
	}
	
	static void method1() throws Exception{
		method2();
	}

	static void method2() throws Exception{
		throw new Exception(); //Exception 인스턴스를 생성
	}
	
	/*
	[출력 결과]
	Exception in thread "main" java.lang.Exception
		at ex08_Exception.MethodThrow.method2(MethodThrow.java:13)
		at ex08_Exception.MethodThrow.method1(MethodThrow.java:9)
		at ex08_Exception.MethodThrow.main(MethodThrow.java:5)

	결론 : 결국 어느 한 곳에서는 반드시 try~catch문으로 예외처리를 해주어야 한다.
	예외가 선언되어 있으면 Exception과 같은 checked 예외를 try~catch문으로 처리하지 않아도 컴파일 에러가 발생하지 X
	
	예외 선언 방법 : 키워드 throws를 사용하여 발생할 수 있는 예외를 적어주기
	 */
}
