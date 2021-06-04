package project1;

import java.util.Scanner;

import project1.ver03.PhoneBookManager;

public class PhoneBookVer09 {

//	public static void printMenu() {
//		System.out.println("========선택하세요========");
//		System.out.printf("1.데이터 입력 | 2. 데이터 검색 | 3. 데이터 삭제 | 4. 주소록 출력 | 5.프로그램 종료\n");
//		System.out.print("선택:");
//	}
	
	public static void main(String[] args) {
		
		PhoneBookManager pbm = 
				new PhoneBookManager(100);
		
		while(true) {
			
			pbm.printMenu();
			
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt(); 
				
			switch (choice) {
			case 1:
				pbm.dataInput(choice);
				System.out.println();
				break;
				
			case 2:
				pbm.dataSearch();
				break;

			case 3:
				pbm.dataDelete();
				break;
			
			case 4:
				pbm.dataAllShow();
				break;

			case 5:
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
