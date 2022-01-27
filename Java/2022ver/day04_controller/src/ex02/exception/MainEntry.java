package ex02.exception;

import java.util.Scanner;

public class MainEntry {
	/*
	public static void main(String[] args) {
		System.out.println("integer data 2 input : ");
		int x = new Scanner(System.in).nextInt();
		int y = new Scanner(System.in).nextInt();
		
		int result = x/y;		// **어떠한 수를 0으로 나눌 수 있나? (X_불능) | 0을 어떠한 수로 나눌 수 있나? (O)
		
		System.out.println(result);
	}
	*/
	
	/***************************************************/
	
	/*
	public static void main(String[] args) {
		System.out.println("integer data 2 input : ");
		Scanner sc = new Scanner(System.in);
		int x, y, result=0;
		x = sc.nextInt();
		y = sc.nextInt();
		
		if (y!=0) result = x / y;
		else {
			System.out.println("0으로 나눌 수 없습니다!");
			System.exit(0);				// ** .exit(0) : prog.를 강제종료 시키겠다.
		} 
		System.out.println(result);
	}
	*/
	
	/***************************************************/
	
	public static void main(String[] args) {
		System.out.println("integer data 2 input : ");
		Scanner sc = new Scanner(System.in);
		int x, y, result=0;
		
		/*
		[try~catch 구문]
		try									//반드시 1개만 가능
			try 블록						//문제가 될 코드를 try 블록 안에 넣는다.
		catch (exception타입 exception변수)	//1개 또는 다중 가능	>> catch절(catch clause_구/절), 반복 가능
			catch 블록
		finally								//반드시 1개만 가능		>> finally절(finally clause), 생략 가능
			finally 블록
		*/
		
		try {
			x = sc.nextInt();		//입력은 try문 밖/안 상관 X
			y = sc.nextInt();
			
			result = x / y;			//문제발생 있음
			
			System.out.println(x + " / " + y + " = " + result);
			
		} catch(Exception e) {				//모든 처리는 Exception 클래스가 가지고 있음. + 옆에 e라고 한 것은 아무거나 가능
			//System.out.println("0으로 나눌 수 없습니다!");		//문제를 catch가 받는다.
			//System.out.println(e.getMessage());					//발생한 error의 메세지를 가져와 출력해라.
			e.printStackTrace(); 					//단계별로 error를 찾아서 error를 print 해주어라. + 해당 코드의 줄까지 알 수 있다. (Trace : 추적)
		} 
	} 
	
	
	
	
}
