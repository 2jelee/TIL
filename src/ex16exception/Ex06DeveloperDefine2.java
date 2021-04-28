package ex16exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
사용자정의 예외클래스
1.Exception클래스를 상속받는다. 
2. 생성자에서 예외발생시 출력할 메세지를 super()를 통해 입력한다.
3. 예외 발생지점에서 if문으로 감지한후 예외객체를 생성 및 throw 한다. 
4. catch문에서 예외객체를 받아 처리한다.  
 */
class AgeErrorException2 extends Exception {
	public AgeErrorException2() {
		super("나이 입력이 개잘못 되었어요");
	}
}

public class Ex06DeveloperDefine2 {

	public static void main(String[] args) {

		System.out.print("나이를 입력하세요 : ");		 
		int age = readAge();
		System.out.println("당신의 나이는 "+ age +" 입니다.");
	}

	public static int readAge() {
		Scanner sc = new Scanner(System.in);
		int inputAge=0;
		try {
			//나이 입력시 문자를 입력하는 경우의 예외는 여기서 처리..
			inputAge = sc.nextInt();
		}
		catch(InputMismatchException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		try {
			//나이가 음수값이 입력되면 개발자정의 예외객체를 생성한 후 throw한다.
			if(inputAge<0) {
				AgeErrorException2 ex = new AgeErrorException2();
				throw ex;/*
						throw하면 반드시 catch해야한다.
						그렇지 않으면 프로그램이 종료된다. */						
			}
		}
		catch (AgeErrorException2 e) {
			System.out.println(e.getMessage());
		}	
			
		return inputAge;
	}
}
