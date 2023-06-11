package project1;

import java.util.Scanner;

import project1.ver05.MenuItem;
import project1.ver05.PhoneBookManager;

public class PhoneBookVer05 {

	public static void main(String[] args) {
		
		PhoneBookManager pbm = 
				new PhoneBookManager(100);
		
		while(true) {
			
			pbm.printMenu();
			
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt(); 
			
			switch (choice) {
			case MenuItem.DATAINPUT:
				pbm.subPrintMenu();
				pbm.dataInput(choice);
				break;
				
			case MenuItem.DATASEARCH:
				pbm.dataSearch();
				break;

			case MenuItem.DATADELETE:
				pbm.dataDelete();
				break;
			
			case MenuItem.DATAALLSHOW:
				pbm.dataAllShow();
				break;

			case MenuItem.EXIT:
				System.out.println("[시스템] 프로그램을 종료합니다.");
				return;
				
			default:
				System.out.println("[시스템] 1과 2 중에서 선택하시오.");
				System.out.println();
				break;
			}
		}
	}
}
