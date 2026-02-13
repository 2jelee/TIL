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

public class Quiz_PartTime extends Quiz_Employee {
	protected int day, time;
	
	public Quiz_PartTime(String name, String dep, String phoneNum, String position){
		super.setName(name);
		super.setDep(dep);
		super.setPhoneNum(phoneNum);
		super.setPosition(position);
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	@Override
	public void infoData() {
//		super.infoData();
		Scanner sc = new Scanner(System.in);
		System.out.print("근무일수 : ");
		setDay(sc.nextInt());
		System.out.print("근무시간 : ");
		setTime(sc.nextInt());
	}
	
	@Override
	public String toString() {
		return "Quiz_PartTime [day=" + day + ", time=" + time + "]";
	}
}
