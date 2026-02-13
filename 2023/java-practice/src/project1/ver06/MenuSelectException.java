package project1.ver06;

import java.util.InputMismatchException;
import java.util.Scanner;

//import project1.MenuSelectException;

class MSE extends Exception{
	public MSE() {
		super("[시스템] 1~5번 중에서 선택하시오.\n");
	}
}
public class MenuSelectException {
	
	public static int readChoice() {
		Scanner sc = new Scanner(System.in);
		int choiceNum=0;
		try {
			//메뉴 번호 입력에 '문자'를 입력하는 경우의 처리
			choiceNum = sc.nextInt();
		}
		catch(InputMismatchException e) {
			System.out.println("[시스템] 숫자가 아닌 문자를 입력했습니다.");
		}
//		return choiceNum;
		
		//메뉴 번호 입력에 1~5(지정)외의 정수를 입력한 경우의 처리
		try {
			if(!(choiceNum>=1 && choiceNum<=5)) {	 //asciiCode>=48 && asciiCode<=57
				MSE ex = new MSE();
				throw ex;
			}
		}
		catch (MSE e) {
			System.out.println(e.getMessage());
//			System.out.println("[시스템] 숫자가 아닌 문자를 입력했습니다.");
		}
		return choiceNum;
	}
}