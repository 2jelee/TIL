package project1;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.MenuSelectionManager;

import project1.ver06.MenuItem;
import project1.ver06.MenuSelectException;
import project1.ver06.PhoneBookManager;


public class PhoneBookVer06 {

	public static void main(String[] args) {
		
		PhoneBookManager pbm =  new PhoneBookManager(100);
		Scanner sc = new Scanner(System.in);
		
		MenuSelectException m = new MenuSelectException();
		
		while(true) {
			pbm.printMenu();
			int choice = m.readChoice();
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
			}
		}
	}
}
	
//			catch(InputMismatchException e) {
//				System.out.println("***try문 : 숫자가 아닌 문자를 입력했습니다.***");
//			}
//	public static int readChoice1() {
//		Scanner sc = new Scanner(System.in);
//		int choiceNum=0;
//		try {
//			//메뉴 번호 입력에 문자를 입력하는 경우의 처리
//			choiceNum = sc.nextInt();
//		}
//		catch(InputMismatchException e) {
//			System.out.println("***숫자가 아닌 문자를 입력했습니다.***");
//		}
//		return choiceNum;
//	}
//}

						
//				default:
//		//			System.out.println("※1과 2 중에서 선택하시오.※");
//		//			System.out.println();
//					break;
//			catch(InputMismatchException e) {
//				System.out.println("***try문 : 숫자가 아닌 문자를 입력했습니다.***");
//			}
//		}
//	}
////			e.printStackTrace();
////			System.exit(0);
////			System.exit(choiceNum);
////		}
////		////////////////////////////////////////////////////////////
//		try {
//			if(!(choiceNum>=1 && choiceNum<=5)) {	 //asciiCode>=48 && asciiCode<=57
//				MenuSelectException ex = new MenuSelectException();
//				throw ex;
////			}
////			else {
////				throw MenuItem.DATAINPUT;
//			}
//		}
//		catch (MenuSelectException e) {
//			System.out.println(e.getMessage());
//		}
//		return choiceNum;
//	}
//}
