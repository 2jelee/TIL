package ex03.Switch;

import java.util.Scanner;

/*
public class MainSwitch {
	public static void main(String[] args) {
		
		System.out.print("도시를 선택하세요(선택 : i,s,d,j) ");
		String city = new Scanner(System.in).next();	// .next 또는 nextLine 가능
		
		switch (city) {	//조건 - 문자형, 정수형(long형 제외_너무 숫자가 크므로) 가능 | 실수형 X
			case "i":							// colon이 {}(블럭)이라고 생각	 | String(문자열)이므로""
				System.out.print("인천"); break;
			case "s":
				System.out.print("서울"); break;
			case "d":
				System.out.print("대구"); break;
			case "j":
				System.out.print("제주"); break;
			default:		//생략하지 않는 것이 좋다!
				System.out.print("없는 도시입니다. ※i,s,d,j 중 선택※");
				
				System.exit(0);	//prog 강제종료
//				break;
		} //end of switch 
		System.out.println("을(를) 선택하셨습니다.");
		
	}
}
*/

/*********************************************************/
 
/*
public class MainSwitch {
	public static void main(String[] args) {
		
		System.out.print("도시를 선택하세요(선택 : i,s,d,j) ");
		char city = new Scanner(System.in).next().charAt(0);	// .charAt(0) : 앞글자 따와
		
		switch (city) {	//조건 - 문자형, 정수형(long형 제외_너무 숫자가 크므로) 가능 | 실수형 X
			case 'i':							// char(문자)이므로 ''
				System.out.print("인천"); break;
			case 's':
				System.out.print("서울"); break;
			case 'd':
				System.out.print("대구"); break;
			case 'j':
				System.out.print("제주"); break;
			default:		//생략하지 않는 것이 좋다!
				System.out.print("없는 도시입니다. ※i,s,d,j 중 선택※");
				
				System.exit(0);	//prog 강제종료
//				break;
		} //end of switch 
		System.out.println("을(를) 선택하셨습니다.");
		
	}
}
*/

/*********************************************************/

public class MainSwitch {
	public static void main(String[] args) {
		
		System.out.print("도시를 선택하세요(선택 : i,s,d,j) ");
		double city = new Scanner(System.in).nextDouble();	 
		
		
		// ※절대 실수형을 사용할 수 없으므로 (int)를 사용함으로써 형변환!	>> 위에 따로 선언해서 switch 식에서 형변환 하지 않아도 O
		switch ((int)city) {
			case 'i':						 
				System.out.print("인천"); break;
			case 's':
				System.out.print("서울"); break;
			case 'd':
				System.out.print("대구"); break;
			case 'j':
				System.out.print("제주"); break;
			default:		//생략하지 않는 것이 좋다!
				System.out.print("없는 도시입니다. ※i,s,d,j 중 선택※");
				
				System.exit(0);	//prog 강제종료
//				break;
		} //end of switch 
		System.out.println("을(를) 선택하셨습니다.");
		
	}
}
