package ex08_Exception;

public class Throw02 {
	public static void main(String[] args) {
		try {
//			Exception e = new Exception();
//			throw e; //예외 발생시키기
			
			//위 두 줄을 한줄로 줄일 경우
			throw new Exception("고의로 발생시키기");
		} catch (Exception e) {
			System.out.println("Error 메세지 : " + e.getMessage()); // 결과 : Error 메세지 : 고의로 발생시키기
			e.printStackTrace(); 									// 결과 : java.lang.Exception: 고의로 발생시키기
		}
		System.out.println("프로그램 정상 종료!");
	}
	/*
	[출력 결과]
	Error 메세지 : 고의로 발생시키기
	java.lang.Exception: 고의로 발생시키기
	프로그램 정상 종료!
		at ex08_Exception.Throw02.main(Throw02.java:10)
	 */
}
