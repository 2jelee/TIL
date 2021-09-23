package project1;

import java.util.Scanner;
import project1.ver02.PhoneInfo;

public class PhoneBookVer02 {

	public static void printMenu() {
		System.out.println("=============선택하세요=============");
		System.out.printf("1.데이터 입력   |   2.프로그램 종료\n");
		System.out.print("선택:");
	}
	
	public static void main(String[] args) {
			
		while(true) {
			
			printMenu();

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt(); 
				
			switch (choice) {
			case 1:
				System.out.print("이름 : ");
				String name = sc.nextLine();
				sc.nextLine();
				System.out.print("전화번호 : ");
				String num = sc.nextLine();
				System.out.print("생년월일 : ");
				String birth = sc.nextLine();
				
				System.out.println();
				System.out.println("입력한 정보를 출력합니다.");
				PhoneInfo pI3 = new PhoneInfo(name, num, birth);
				pI3.showPhoneInfo();
				System.out.println();
				break;
				
			case 2:
				System.out.println("프로그램을 종료합니다.");
				return;
				
			default:
				System.out.println("※1과 2 중에서 선택하시오.※");
				System.out.println();
				break;
			}
		}
	}
}
