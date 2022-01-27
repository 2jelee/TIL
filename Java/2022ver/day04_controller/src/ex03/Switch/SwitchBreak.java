package ex03.Switch;

import java.util.Scanner;

public class SwitchBreak {
	public static void main(String[] args) {
		
		System.out.print("당신의 포인트는? ");
		int point = new Scanner(System.in).nextInt();
		
		switch (point) {
			case 1:	System.out.print("집"); //break;
			case 2:	System.out.print("피아노"); //break;
			case 3: System.out.print("우산"); //break;
//			default:									 // (상품을) 누적해서 출력할(줄) 것이라면 default 없애기
//				System.out.print("잘못 선택하셨습니다. ");
//				System.exit(0);	//prog 강제종료
		} //end of switch 

		System.out.println("상품에 당첨되었습니다. 축하합니다!");
	}
}
