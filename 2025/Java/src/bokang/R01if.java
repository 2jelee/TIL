package bokang;

import java.util.Scanner;

public class R01if {

	public static void main(String[] args) {
		
		/*
		if문 단독사용
		 */
		int num1 = 10;
		int num2 = 20;
		if(num1<num2) {
			System.out.println("num1이 num2보다 작다.");
		}
		
		//위 문장을 if~else문으로 변경하면..
		if(num1>num2) {
			System.out.println("num1이 num2보다 크다");
		}
		else {
			System.out.println("num1이 num2보다 작다");
		}
		/*
		주의] else문에는 조건이 들어가지 않는다. 
		조건은 항상 if문에만 들어가야 한다. 
		 */
		
		/*
		시나리오] 90점이상 : A학점
			80이상~90점미만 : B학점
			나머지는 F학점
			
			: 점수의 구간같은 경우에는 이상, 이하에 해당하는
			두조건을 묶어주는게 안전하다. 
		 */
		int jumsu = 85;
		if(jumsu>=90) {
			System.out.println("A학점");
		}
		else if(jumsu>=80 && jumsu<90) {
			System.out.println("B학점");
		}
		else {
			System.out.println("F학점");
		}
		
		/*********************************************/
		
		/*
		switch문
		: if문과 같은 조건문이지만 다른점은 if문은 조건식이 들어가는
		반면, switch문은 산술식이 들어간다. 
		 */
		
		/*
		시나리오] 월에 해당하는 1~12까지의 숫자를 입력받아서
			봄(3~5), 여름(6~9), 가을(10~11), 겨울(12~2)인지 판단하는 
			switch~case문을 작성해보시오.
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.print("1~12까지의 정수를 입력하세욤:");
		int month = scanner.nextInt();
		switch(month) {
		case 3:case 4:case 5://if문의 or(||)조건같은 형식
			System.out.println("3~5월은 봄입니다.");
			break;
		case 6:case 7:case 8:case 9:
			System.out.println("6~9월은 여름입니다.");
			break;
		case 10:case 11:
			System.out.println("10~11월은 가을입니다.");
			break;
		case 12:case 1:case 2:
			System.out.println("12~2월은 겨울입니다.");
			//마지막 부분은 break가 없어도 무방하다.
		}
		/*
		만약 4를 입력했다면 break가 없는경우 아래의 모든 
		문장이 출력되게된다. 따라서 해당 조건에 맞는 출력문을
		위해서는 반드시 break을 써줘야한다. 
		 */

	}

}
