package project1;
import java.io.IOException;
import java.util.Scanner;

import project1.ver08.AutoSaverT;
import project1.ver08.MenuItem;
import project1.ver08.PhoneBookManager;


public class PhoneBookVer08 {

	public static void main(String[] args) throws IOException {
		
		PhoneBookManager pbm =  new PhoneBookManager();
		AutoSaverT autoS = new AutoSaverT();
		
		Scanner sc = new Scanner(System.in);

		while(true) {
			
			pbm.printMenu();
			int choice = sc.nextInt();
			
			switch (choice) {
				case MenuItem.DATAINPUT:
				System.out.println("데이터 입력을 시작합니다.");
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
				case MenuItem.SAVE:
					int saveChoi;
					System.out.println("=====저장 옵션 선택=====");
					System.out.println("저장 옵션을 선택하세요.");
					System.out.println("1. 자동저장 On  |  2. 자동저장 Off");
					System.out.printf("선택 : "); saveChoi=sc.nextInt();
					if (saveChoi == 1) {
						System.out.println("자동저장을 시작합니다.");
						pbm.saveInfo();
						autoS.start();
					}
					else if(saveChoi == 2) {
						System.out.println("자동저장을 종료합니다.");
						autoS.interrupt();
					}
					break;
								
				case MenuItem.EXIT:
					pbm.saveInfo();
					System.out.println("obj 파일로 저장되었습니다.");
					System.out.println("프로그램을 종료합니다.");
					return;
			}
		}
	}
}
//						autoS.isAlive();
//						System.out.println("[경고] 이미 자동저장이 실행중입니다.");