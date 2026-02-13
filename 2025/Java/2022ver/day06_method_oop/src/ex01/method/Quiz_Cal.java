package ex01.method;

/*
[문제4]
add(x, y), sub(-), mul(*), div(/)

div 처리.......................................................... 다시 풀기
*/

public class Quiz_Cal {

	public static int add(int x, int y) {	 
		int sum = x+y;
		return sum;
	}

	public static int sub(int x, int y) { 
		int sub = x-y;
		return sub;
	}

	public static int mul(int x, int y) {	 
		int gop = x*y;
		return gop;
	}
	
	public static int div(int div) {	 
		int x=0, y=0; 
		try {		
			if(y!=0) { 
				div = x/y; 
			}
		} 
		catch (Exception e) {				//하위 error(예외) 위치
			System.out.println("해당 계산에서는 값을 0으로 나눌 수 없습니다. Exception message : "+ e);
		}
		return div; 
	}
	 
	
	public static void main(String[] args) {  
		System.out.println("덧셈 : "+ add(1, 3));
		System.out.println("뺄셈 : "+ sub(4, 3));
		System.out.println("곱셈 : "+ mul(3, 3));
//		System.out.println("나누기 : "+div(3));		
	}
//	*/
	
	/******************************************************************/
	
	
}
