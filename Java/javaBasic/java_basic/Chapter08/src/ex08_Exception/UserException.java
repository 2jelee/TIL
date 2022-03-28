package ex08_Exception;

/*
두 개의 사용자 정의 예외 클래스 생성 -> SpaceException, MemoryException
Exception을 상속받아서 생성

=> Exception 클래스로부터 상속받음
	멤버변수나 메서드를 추가할 수 있는데,
	Exception 클래스는 생성 시에 String 값을 받아서 메세지로 저장할 수 있다.
	개발자가 만든 사용자 정의 예외 클래스에 메세지를 저장하려면,
	String을 매개변수로 받는 생성자를 추가해주면 된다.
 */

class SpaceException extends Exception{
	SpaceException(String msg){
		super(msg); 	// 조상인 Exception 클래스의 생성자를 호출
	}
}

class MemoryException extends Exception{
	MemoryException(String msg){
		super(msg);
	}
}

class UserException {
	
	public static void main(String[] args) {
		try {
			startInstall();
			copyFiles();
		} catch (SpaceException e) {
			System.out.println("에러 메세지 : " +e.getMessage());
			e.printStackTrace();
			System.out.println("공간을 확보한 후 다시 설치하시기 바랍니다.");
		} catch (MemoryException me) {
			System.out.println("에러 메세지 : " + me.getMessage());
			me.printStackTrace();
			System.gc(); //Garbage Collection을 수행하여 메모리를 늘려줌.
		} finally {
			deleteTempFiles(); //프로그램 설치에 사용된 임시파일들을 삭제
		}
	}
	
	static void startInstall() throws SpaceException, MemoryException{
		if(!enoughSpace()) {
			throw new SpaceException("설치할 공간이 부족합니다.");
		}
		if(!enoughMemory()) {
			throw new MemoryException("메모리가 부족합니다..");
		}
	}
	
	static void copyFiles() { /* 파일을 복사하는 코드 */ }

	static void deleteTempFiles() { /* 임시파일들을 삭제하는 코드를 적는다. */ }
	
	static boolean enoughSpace() {
		return false;
	}

	static boolean enoughMemory() {
		return true;
	}
}

/*
[실행 결과]
에러 메세지 : 설치할 공간이 부족합니다.
ex08_Exception.SpaceException: 설치할 공간이 부족합니다.
	at ex08_Exception.UserException.startInstall(UserException.java:36)
	at ex08_Exception.UserException.main(UserException.java:19)
공간을 확보한 후 다시 설치하시기 바랍니다.
*/ 