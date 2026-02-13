package project1.ver07;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class PhoneBookManager {
	
	int choi;

	HashSet<PhoneInfo> hset = new HashSet<PhoneInfo>();
	Scanner sc = new Scanner(System.in);
	
	//멤버메소드명 0 : 메뉴 출력
	public void printMenu() {
		System.out.println("===========================선택하세요===========================");
		System.out.printf("1.주소록 입력 | 2. 검색 | 3. 삭제 | 4. 출력 | 5. 프로그램 종료\n");
		System.out.print("메뉴 선택 : ");
	}
	public void subPrintMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("========주소록을 입력함========");
		System.out.printf("1.일반 | 2.동창 | 3. 직장동료\n");
		System.out.printf("선택 >> "); choi = sc.nextInt();
	}
	
	
	//멤버메소드명 1 : 입력 및 저장
	public void dataInput(int choice) throws IOException {	
		String name, phone, major, comName;
		int grade;
//		int asciiCode = System.in.read();
		
		//subPrint 출력
		
		//공통사항
		System.out.print("이름 : "); name = sc.nextLine();
		System.out.print("전화번호 : "); phone = sc.nextLine();

		if(choi==SubMenuItem.GENERAL) {
			if(!hset.add(new PhoneInfo(name, phone))) {
				System.out.println("이미 저장된 데이터입니다.");
				System.out.printf("덮어쓸까요? Y(y) / N(n)");		
//				String cho = sc.nextLine();
				int asciiCode = System.in.read();
				if(asciiCode=='Y' || asciiCode=='y') { //Y,y
//					System.out.println("Y(y)를 누르셨군요");
					hset.remove(new PhoneInfo(name, phone));
					hset.add(new PhoneInfo(name, phone));
					System.out.println("입력한 정보가 저장되었습니다.");
				}
				else if(asciiCode=='N'|| asciiCode=='n'){ //N,n
					System.out.println("저장된 내용을 덮어쓰지 않습니다.");
//					pi.showPhoneInfo();
				}
				else {
					System.out.println("Y(y) 또는 N(n) 중에서 다시 선택하십시오.");
				}
			}
		}
		else if((choi==SubMenuItem.FRIEND)) {
			System.out.print("전공:"); major = sc.nextLine();
			System.out.print("학년:"); grade = sc.nextInt();
			
			if(!hset.add(new PhoneSchoolInfo(name, phone, major, grade))) {
				System.out.println("이미 저장된 데이터입니다.");
				System.out.printf("덮어쓸까요? Y(y) / N(n)");		
//				String cho = sc.nextLine();
				int asciiCode = System.in.read();
				if(asciiCode=='Y' || asciiCode=='y') { //Y,y
//					System.out.println("Y(y)를 누르셨군요");
					hset.remove(new PhoneSchoolInfo(name, phone, major, grade));
					hset.add(new PhoneInfo(name, phone));
					System.out.println("입력한 정보가 저장되었습니다.");
				}
				else if(asciiCode=='N'|| asciiCode=='n'){ //N,n
					System.out.println("저장된 내용을 덮어쓰지 않습니다.");
//					pi.showPhoneInfo();
				}
				else {
					System.out.println("Y(y) 또는 N(n) 중에서 다시 선택하십시오.");
				}
			}
		}
		else if(choi==SubMenuItem.COLLEAGUE) {
			System.out.print("회사:"); comName = sc.nextLine();
			if(!hset.add(new PhoneCompanyInfo(name, phone, comName))) {
				System.out.println("이미 저장된 데이터입니다.");
				System.out.printf("덮어쓸까요? Y(y) / N(n)");		
//				String cho = sc.nextLine();
				int asciiCode = System.in.read();
				if(asciiCode=='Y' || asciiCode=='y') { //Y,y
//					System.out.println("Y(y)를 누르셨군요");
					hset.remove(new PhoneCompanyInfo(name, phone, comName));
					hset.add(new PhoneInfo(name, phone));
					System.out.println("입력한 정보가 저장되었습니다.");
				}
				else if(asciiCode=='N'|| asciiCode=='n'){ //N,n
					System.out.println("저장된 내용을 덮어쓰지 않습니다.");
				}
				else {
					System.out.println("Y(y) 또는 N(n) 중에서 다시 선택하십시오.");
				}
			}
		}
		System.out.println("[시스템] 입력이 완료되었습니다.");
	}////end of dataInput 
			
	
	//멤버메소드명 2 : 데이터 검색	
	public void dataSearch() {
			
		boolean isFind = false;
		System.out.println("데이터 검색을 시작합니다.");
		System.out.print("이름 : ");
		String searchName = sc.nextLine();
		
		for(PhoneInfo pi : hset) {
			if(searchName.contains(pi.name)) {
				pi.showPhoneInfo();
				System.out.println("[시스템] 데이터 검색이 완료되었습니다.");
			}
			else if(isFind==false)
				System.out.println("[시스템] 찾는 정보가 없습니다.");
				System.out.println();
		}
	}////end of dataSearch
	
	
	//멤버메소드명 3 : 삭제 
	public void dataDelete() {
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = sc.nextLine();

		if(hset.add(new PhoneInfo(deleteName, "?"))) {
			hset.remove(new PhoneInfo(deleteName, "?"));
			System.out.println("[시스템] 삭제된 데이터가 없습니다.");
		}
		else {
			hset.remove(new PhoneInfo(deleteName, "?"));
			
			System.out.println("[시스템] 데이터가 삭제되었습니다.");
		}
	}////end of dataDelete	
	
	
	//멤버메소드명 4 : 주소록 전체 출력
	public void dataAllShow() {
		for(PhoneInfo pi : hset) {
			pi.showPhoneInfo();
		}
		System.out.println("[시스템] 전체정보가 출력되었습니다.");
	} 
}