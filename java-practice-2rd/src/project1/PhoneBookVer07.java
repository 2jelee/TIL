package project1;
import java.io.IOException;
import java.util.Scanner;

import project1.ver07.MenuItem;
import project1.ver07.PhoneBookManager;


public class PhoneBookVer07 {

	public static void main(String[] args) throws IOException {
		
		PhoneBookManager pbm =  new PhoneBookManager();
		Scanner sc = new Scanner(System.in);
		
			while(true) {
			pbm.printMenu();
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
					System.out.println("프로그램을 종료합니다.");
					return;
					
				default:
					System.out.println("[시스템] 1~5번 중에서 선택하시오.");
					System.out.println();
					break;
			}
		}
	}
}