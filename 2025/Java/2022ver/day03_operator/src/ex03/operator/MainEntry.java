package ex03.operator;

//최단산쉬관논삼대콤

public class MainEntry {
	/*
	public static void main(String[] args) {
		//논리연산자 : 두 가지로 가능 			   ▶ AND(&_2진, &&_10진) OR(|, ||) XOR(^_2진만), not(!_10진에서만)
		//1. 2진 논리 → 결과를 값으로 출력				
		//2. 10진 논리 → 결과가 참/거짓으로 나온다.
		
		int x = 4, y = 7;
		
		System.out.println(x & y);	//4
		System.out.println(x | y);	//7
		System.out.println(x ^ y);	//3
		
		int a = 10, b = 20, c = 30;
		boolean result = true;
		
		result = (a>b)&&(b>c);		// '&&(AND)'연산은 앞이 거짓이면 뒤는 수행 X
		System.out.println(result);

		result = (a<b)||(b>c);		// '||(OR)'연산은 앞이 참이라면 뒤는 수행 X
		System.out.println(result);
		
		System.out.println(!result);
	}
	*/
	 
	
	public static void main(String[] args) {
		//대입연산자 : =, +=, -=, >>=, <<=, /=, %=, *=, ...
		
		int x=3, y=5, result;
		result = x+y;
		/*
		 * x = x+y; //8 x = x*y; //8*5 System.out.println(x);
		 */
		x = x + y;
		x += y;		//이는 위보다 처리속도 ↑
		
		x = x * y;
		x *= y;
		System.out.println(x);
	}
}
