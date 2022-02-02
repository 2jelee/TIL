package chapter04;

import java.util.Scanner;

public class Switch {
	public static void main(String[] args) {
		System.out.println("현재 월을 입력하세요.");
		System.out.print("현재의 월은 ");
		
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		System.out.println("월");
		
		switch (month) {
		case 3:
		case 4:
		case 5:
			System.out.print("봄");
			break;
		case 6: case 7: case 8:
			System.out.print("여름");
			break;
		case 9: case 10: case 11:
			System.out.print("가을");
			break;
		default:
//		case 12: case 1: case 2:
			System.out.print("겨울");
//			break;
		}
		System.out.println("입니다.");
	}	//end of Main
}
