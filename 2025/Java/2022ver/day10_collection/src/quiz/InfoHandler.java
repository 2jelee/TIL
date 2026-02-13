package quiz;

import java.util.Scanner;

public class InfoHandler {
	protected Customer[] cust;
	protected int numOfCustomer;
	
	public InfoHandler(int num) {
		cust = new Customer[num];
		numOfCustomer = 0;
	}
	
	public void addCustomer(int choice) {
		Scanner sc = new Scanner(System.in);
		
		String iName, iPhone, iAddr;
		
		System.out.print("이름 : "); iName=sc.next();
		System.out.print("연락처 : "); iPhone=sc.next();
		System.out.print("주소 : "); iAddr=sc.next();
		System.out.println("고객 정보 입력이 완료");
	}
	public void showData() {
		for(int i=0; i<numOfCustomer; i++) {
			cust[i].showData();
		}
		System.out.println("전체정보가 출력됨");
	}
	
	public void deleteInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요 : ");
		String deleteName = sc.next();
		int deleteIndex = -1;
		
		for (int i = 0; i < numOfCustomer; i++) {
			if(deleteName.compareTo(cust[i].name)==0) {
				cust[i] = null;
				deleteIndex = i;
				numOfCustomer--;
			}
		}
		if(deleteIndex==-1) {
			System.out.println("삭제된 데이터가 없습니다.");
		}
		else {
			for(int i=deleteIndex; i<numOfCustomer; i++) {
				cust[i] = cust[i+1];
			}
			System.out.println("데이터("+deleteIndex+"번)가 삭제되었습니다.");
		}
	}
}
