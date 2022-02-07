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

public class Quiz_Sales extends Quiz_Regular { 

	protected double commission;
	 
	public Quiz_Sales(String name, String position, String dep, String phoneNum) {
		super(name, position, dep, phoneNum);
		super.setSalary(salary);
		// TODO Auto-generated constructor stub
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}
	
	@Override
	public String toString() {
		return "Quiz_Sales [commission=" + commission + "]";
	}

	@Override
	public void infoData() {
//		super.infoData();
		Scanner sc = new Scanner(System.in);
		System.out.print("커미션 : ");
		setCommission(sc.nextDouble());
		super.setSalary((int)(super.getSalary()*1.3));
	} 
} 