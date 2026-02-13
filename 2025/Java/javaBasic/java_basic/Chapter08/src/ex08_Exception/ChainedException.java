package ex08_Exception;

import javax.management.RuntimeErrorException;

class InstallException extends Exception{
	InstallException(String msg) {
		super(msg);
	}
}
class SpaceException2 extends Exception{
	public SpaceException2(String msg) {
		super(msg);
	}
}

class MemoryException2 extends Exception{
	MemoryException2(String msg){
		super(msg);
	}
}

class ChainedException {
	public static void main(String[] args) {
		try {
			install();
		} catch (InstallException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void install() throws InstallException{
		try {
			startInstall(); // 프로그램 설치에 필요한 준비를 한다.
			copyFiles();	// 파일들을 복사
		} catch (SpaceException2 e) {
			InstallException ie = new InstallException("설치 중 예외 발생!");
			ie.initCause(e);
			throw ie;
		} catch (MemoryException2 me) {
			InstallException ie = new InstallException("설치 중 예외 발생!!");
			ie.initCause(me);
			throw ie;
		} finally {
			deleteTempFiles(); // 프로그램 설치에 사용된 임시파일들을 삭제
		}
	}
	
	static void startInstall() throws SpaceException2, MemoryException2{
		// 충분한 설치 공간이 없을 경우,
		if(!enoughSpace()) {
			throw new SpaceException2("설치할 공간이 부족합니다.");
		}
		// 충분한 메모리가 없을 경우,
		if(!enoughMemory()) {
			throw new MemoryException2("메모리가 부족합니다.");
//			throw new RuntimeErrorException(new MemoryException("메모리가 부족합니다."));
		}
	}
	
	static void copyFiles() { /* 파일들을 복사하는 코드 */ };
	static void deleteTempFiles() { /* 임시 파일들을 삭제하는 코드 */ };
	
	static boolean enoughSpace() {
		//설치하는데 필요한 공간이 있는지 확인하는 코드 적기
		return false;
	}
	static boolean enoughMemory() {
		//설치하는데 필요한 메모리 공간이 있는지 확인하는 코드 적기
		return false;
	}
}
