package ex04;

import java.util.Scanner;

public class BreakAndContinue {
	public static void main(String[] args) {
		int menu = 0, num = 0;
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("(1) square");
			System.out.println("(2) square root");
			System.out.println("(3) log");
			System.out.print("원하는 메뉴 1~3 중에서 선택 (종료 : 0) ");
			
			String temp = sc.nextLine();
			menu = Integer.parseInt(temp);
//			int temp = sc.nextInt();
//			menu = temp;
			
			if(menu==0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if (!(1<=menu && menu <=3)) {
				System.out.println("메뉴를 잘못 선택했습니다. (종료는 0입니다.)");
				continue;
			}
			
			System.out.println("선택하신 메뉴는 " + menu +"번 입니다.");
		}
	}
}
