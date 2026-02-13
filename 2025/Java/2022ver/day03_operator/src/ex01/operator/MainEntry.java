/*
package ex01.operator;

// 최단산쉬관논삼대콤
public class MainEntry {
	public static void main(String[] args) {
		//단항연산자 : 증감 → ++, --, ~(부정연산자) 등
		int x = 10, y;
		
//		y = x++; //후위연산 : 대입먼저, 연산은 나중에
//		y = ++x; //전위연산 : 연산(증가)먼저, 대입 나중에
//		y = x--;
		
		++x; //x++;든지 단독으로 쓰일 경우, 결과는 같다.
		y=x;
		
		System.out.println("x = " + x + "\ty = " + y);
	}
}
*/


//package ex01.operator;
//
//public class MainEntry {
//	public static void main(String[] args) {
//		int x = 10, y;
//		y= ~10; //비트부정 (틸트연산자)		>> -(원래값+1) → 출력결과
//				// -7 → 6
//		System.out.println("x = " + x + "\ty = " + y);
//	}
//}


//package ex01.operator;
//
//public class MainEntry {
//	public static void main(String[] args) {
//		//산술연산자 : +, -, *, /, % 등
//		int x = 10, y = 20;
//		int gob = x * y;
//		System.out.println("x * y = " + gob);
//		System.out.println("x * y = " + (y*x));
//		
//		System.out.println(x + " * " + y + " = " + (y*x));
//		
//		System.out.println("\n\n 3+4*5 = " + (3+4*5));
//		System.out.println("(3+4)*5 = " + ((3+4)*5));
//		
//		//정수 ( +, -, *, /, % 등_연산) 정수 = 정수
//		System.out.println("\n 7/3 = " + (7/3)); //2, 몫
//		System.out.println("\n 7%3 = " + (7%3)); //1, 나머지
//		
//		System.out.println("\n 7/3.0 = " + (7/3.0)); //2, 몫
//		System.out.println("\n 7./3. = " + (7./3.));
//	}
//}


package ex01.operator;

public class MainEntry {
	public static void main(String[] args) {
		// shift 연산자 : <<, >>, <<<
		//				 왼쪽으로 밀어줘, 오른쪽으로 밀어줘
		int x = 8, y=8, result, result2;
		result = x << 2; 	// left shift : 원래값 * 2^bit수	// 8*2^2
		result2 = y >> 3;	// right shift : 원래값 / 2^bit수	// 8/2^3
		
		System.out.println("left shift : " + result);		// 32
		System.out.println("right shift : " + result2);		// 1
		
	}
}


//package ex01.operator;
//
//public class MainEntry {
//	public static void main(String[] args) {
//
//	}
//}
//
