package quiz;

import java.util.Scanner;

/*
 * 고객 클래스 만들고 
          --> 이름, 주소, 연락처
     
      고객 추가 / 삭제 / 고객 리스트 출력 / 수정 / 프로그램 종료 하는 프로그램 작성하기
 */
class Customer {
	String name, addr, phoneNum;

	public Customer(String name, String phoneNum, String addr) {
		this.name = name;
		this.addr = addr;
		this.phoneNum = phoneNum; 
	}
	public void showData() {
		System.out.println("이름 : " + name);
		System.out.println("주소 : " + addr);
		System.out.println("연락처 : " + phoneNum);
	}
	public void showInfo() { }
}

public static void mensuShow() {
	System.out.println("===메뉴를 선택하세요===");
	System.out.println("1. 고객 추가");
	System.out.println("2. 고객 삭제");
	System.out.println("3. 고객 리스트 출력");
	System.out.println("4. 고객 정보수정");
	System.out.println("5. 프로그램 종료"); 
}

public class Quiz_customer {
	public static void main(String[] args) {
		InfoHandler handler = new InfoHandler(100);
		
		while(true) {
			mensuShow();
			
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1: 
				handler.addCustomer(choice); //고객추가
				break;
			case2 :
				handler.deleteInfo(); //고객삭제
				break;
			case 3 :
				handler.showData();	//정보출력
				break;
			case 4 :
				handler.editInfo(); //정보수정
				break;
			case 5 :
				System.out.println("프로그램 종료");
				return;
			}
		}
	}
}
