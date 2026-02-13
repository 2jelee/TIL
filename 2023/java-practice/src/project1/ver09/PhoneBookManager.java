package project1.ver09;

import java.util.Scanner;

//핸들러
public class PhoneBookManager {
	
	private PhoneInfo[] myPhone;
	private int numOfPhoneBook;
	
	 
	public PhoneBookManager(int num) {
		myPhone = new PhoneInfo[num];
 		numOfPhoneBook = 0;
	}
 
	//멤버메소드명 0 : 메뉴 출력
	public void printMenu() {
		System.out.println("========선택하세요========");
		System.out.printf("1.데이터 입력 | 2. 데이터 검색 | 3. 데이터 삭제 | 4. 주소록 출력 | 5.프로그램 종료\n");
		System.out.print("선택 : ");
	}
	
	//멤버메소드명 1 : 입력
	public void dataInput(int choice) {		
		
		Scanner sc = new Scanner(System.in);
		String name,phone,birth;

		if(choice==1) {	//데이터 입력(1.) 후 추가
			System.out.println("데이터 입력을 시작합니다.");
			System.out.print("이름 : "); name = sc.nextLine();
			System.out.print("전화번호 : "); phone = sc.nextLine();
			System.out.print("생년월일 : "); birth = sc.nextLine();
			
			PhoneInfo one =
					new PhoneInfo(name, phone, birth);
			myPhone[numOfPhoneBook++] = one;
		}
		System.out.println("데이터 입력이 완료되었습니다.");		
	}////end of dataInput 
	
	
	//멤버메소드명 2 : 데이터 검색	
	public void dataSearch() {
			
		boolean isFind = false;
		Scanner scan = new Scanner(System.in);
		System.out.println("데이터 검색을 시작합니다.");
		System.out.print("이름 : ");
		String searchName = scan.nextLine();
		
		PhoneInfo one =
				new PhoneInfo(searchName, searchName, searchName);
		
		for(int i=0 ; i<numOfPhoneBook ; i++) {			
			if(searchName.compareTo(myPhone[i].name)==0) {
				myPhone[i].showPhoneInfo();
				System.out.println("데이터 검색이 완료되었습니다.");
				isFind = true;
			}
		}
			
		if(isFind==false)
			System.out.println("※찾는 정보가 없습니다.※");
	}////end of dataSearch
	
	
	//멤버메소드명 3 : 삭제 
	public void dataDelete() {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();

		int deleteIndex = -1; 

		for(int i=0 ; i<numOfPhoneBook ; i++) {
			if(deleteName.compareTo(myPhone[i].name)==0) {
				myPhone[i] = null;
				deleteIndex = i;
				numOfPhoneBook--;
				break;
			}
		}

		if(deleteIndex==-1) {
			System.out.println("==삭제된 데이터가 없습니다==");
		}
		else {
			for(int i=deleteIndex ; i<numOfPhoneBook ; i++) {
				myPhone[i] = myPhone[i+1];
			}
			System.out.println("==데이터("+ deleteIndex
					+"번)가 삭제되었습니다==");
		}
	}////end of dataDelete	
	
	
	//멤버메소드명 4 : 주소록 전체 출력
	public void dataAllShow() {
		for(int i=0 ; i<numOfPhoneBook ; i++) {
			myPhone[i].showPhoneInfo();
		}
		System.out.println("==전체정보가 출력되었습니다==");
	} 
}