package ex08_Exception;

/*
 * printStackTrace() : 예외 발생 당시의 호출 스택(Call Stack)에 있었던 method의 정보와 예외 메세지를 화면에 출력
 * getMessage() : 발생한 예외 클래스의 인스턴스에 저장된 메세지를 얻을 수 있다.
 */

public class PrintStackTraceAndGetMessage {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		
		try {
			System.out.println(3);
			System.out.println(0/0);
			System.out.println(4);
		} catch (ArithmeticException ae) {
			ae.printStackTrace();
			System.out.println("예외메세지 : " +ae.getMessage());
		}
		System.out.println(6);
	}
}
