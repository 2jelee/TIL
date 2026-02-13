package ex08_Exception;

class ExceptionRe_Throwing {
	public static void main(String[] args) {
		try {
			method1();
		} catch (Exception e) {
			System.out.println("main 메서드에서 예외가 처리됨.");
		}
	}
	
	static void method1() throws Exception{
		try {
			throw new Exception();
		} catch (Exception e) {
			System.out.println("method1 메서드에서 예외가 처리됨.");
			throw e; //다시 예외 발생시키기
		}
	}
	
	/*
	[결과]
	method1 메서드에서 예외가 처리됨.
	main 메서드에서 예외가 처리됨.
	
	>> 이 결과를 통해 method1()과 양쪽의 catch 블럭이 모두 수행되었음을 알 수 있다.
	method1()의 catch 블럭에서 예외를 처리하고도 throw 문을 통해 다시 예외를 발생시켰음.
	그리고 이 예외글 main 메서드에서 한 번 더 처리했음.
	*/
}
