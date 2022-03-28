package ex08_Exception;

public class Throw01 {
	public static void main(String[] args) {
		try {
			Exception e = new Exception();
			throw e; //예외 발생시키기
			
			//위 두 줄을 한줄로 줄일 경우
//			throw new Exception("고의로 발생시키기");
		} catch (Exception e) {
			System.out.println("Error 메세지 : " + e.getMessage()); // 결과 : null
			e.printStackTrace(); 									// 결과 : java.lang.Exception at ex08_Exception.Throw.main(Throw.java:6)
		}
		System.out.println("프로그램 정상 종료!");
	}
	/*
	[출력 결과]
	Error 메세지 : null
	java.lang.Exception
		at ex08_Exception.Throw01.main(Throw01.java:6)
	프로그램 정상 종료! 
	 */
}
