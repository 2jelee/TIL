package ex18lambda;

import java.util.Random;

//매개변수는 있으나 반환값이 없는 람다식
@FunctionalInterface
interface StringConcat{
	public void makeString(String s1, String s2);
}

//매개변수는 없으나 반환값이 있는 람다식
@FunctionalInterface
interface RandomNumber{
	public int randomNum();
}

//매개변수, 반환값 둘다 있는 람다식
@FunctionalInterface
interface GugudanRange{
	public String[][] guguString(int n1, int n2);
}

//매개변수, 반환값 둘다 없는 람다식
@FunctionalInterface
interface MenuPrint {
	public void onlyPrint();
}

public class Ex05ParamNReturn {
	
	public static void main(String[] args) {
		
		
		System.out.println("### 람다식1");
		String s1 = "안녕하세요?";
		String s2 = "람다식입니다.";
		/*
		2개의 문자열을 매개변수로 받아서 연결하여 
		출력해주는 람다식 정의
		*/
		StringConcat sc = (a, b) -> {
			System.out.println(a +" "+ b);
		};
		sc.makeString(s1, s2);		
		
		
	
		System.out.println("\n### 람다식2");
		/*
		난수를 생성한 후 반환해주는 람다식 정의
		 */
		RandomNumber randomNumber = () -> {
			Random random = new Random();
			return random.nextInt(100);
		};
		int rNumber = randomNumber.randomNum();
		System.out.println("생성된 난수:"+ rNumber);
	
		
	
		System.out.println("\n### 람다식3");
		/*
		2개의 정수를 매개변수로 받아 해당 값 사이의 
		구구단을 2차원배열에 저장한 후 반환하는 람다식
		 */
		GugudanRange gugudanRange = (num1, num2) -> {
			
			String[][] gugudan = new String[9][9];
			for (int i=num1 ; i<=num2 ; i++) {
				for (int j=1 ; j<=9 ; j++) {
					gugudan[i-1][j-1] = i+"*"+j+"="+(i*j);
				}
			}
			return gugudan;
		};
		String[][] returnStr = gugudanRange.guguString(4, 6);
		for (int i=4 ; i<=6 ; i++) {
			for (int j=1 ; j<=9 ; j++) {
				System.out.print(returnStr[i-1][j-1]+" ");
			}
			System.out.println();
		}		
		

		System.out.println("\n### 람다식4");
		/*
		문자열을 출력하는 람다식
		 */
		MenuPrint menuPrint = () -> {
			System.out.println("메뉴를 출력합니다");
		};
		menuPrint.onlyPrint();
		
	}
}
