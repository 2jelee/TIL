package ex07.randomClass;

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

public class Quiz_MainEntry { 
	public static void main(String[] args) {
		Quiz_Employee emp = new Quiz_Employee();
		emp.infoData(); 
	}
}
