package ex07.randomClass;

import java.util.Scanner;

/*
[문제] 직원(Employee) class 생성하기
		이름, 직급, 부서, 연락처
		
		[구조]
						상 속							상 속
		Sales(영업)        <------------- Regular			<-------------  Employee(직원관리)
		커미션(double type으로)			  급여								이름,직급,부서,연락처	<< [공통]필요한 최소한의 것만 넣어두는
		ㄴ 급여의몇배로 +
		ex. * 0.3
		
		PartTime			<< Emp를 상속(이,직,부,연 => 전부)받으나, 단, 급여부분은 다르게 계산하자.
		일수 * 시간 단가
		
		메인까지 구현
*/

public class Quiz_Employee { 
	protected String name, position, dep, phoneNum;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	} 
	
	public void infoData() {
		Scanner sc = new Scanner(System.in);
		//name, position, dep, phoneNum;
		System.out.print("이름 : ");
		setName(sc.next());
		System.out.print("직급 : ");
		setPosition(sc.next());
		System.out.print("부서 : ");
		setDep(sc.next());
		System.out.print("연락처 : ");
		setPhoneNum(sc.next());
	}
}
