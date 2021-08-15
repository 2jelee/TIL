package ex16exception;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
런타임에러
-컴파일시에는 체크가 되지않고 실행시에만 발생되는 에러
-main메소드에서 무시하기 위해 throws하더라도 오류가 발생하므로
	반드시 예외처리를 해줘야 한다.(무시할수 없음)
-예외발생시 jvm은 해당 예외클래스를 인스턴스화해서 프로그램쪽으로 
	전달하게되고 try~catch에서 받은후 예외를 처리하게된다. 
 */ 
public class Ex02PreDefineException {
 
	//참조변수를 선언만 하고 객체생성은 하지않은 상태
	static Date toDay;
	
	public static void main(String[] args)  {	

		/*
		배열의 크기를 벗어난 인덱스를 사용했을때 발생되는 예외
		 */
		System.out.println("### ArrayIndexOutOfBoundsException ###");		
		int[] intArr = new int[2];				
		try {
			intArr[0] = 100;
			System.out.println("0번방은:"+ intArr[0]);
			intArr[1] = 200;
			System.out.println("1번방은:"+ intArr[1]);
			
			intArr[2] = 300; //예외가 발생하는 지점... 
			System.out.println("앗~이방은?"+ intArr[2]);//실행되지않음	
		}
		catch(ArrayIndexOutOfBoundsException e) {
			/*
			예외가 발생하면 JVM이 예외객체를 프로그램으로 전달하고
			catch절에서 잡는다. 그러면 프로그램이 종료되지않고 실행이
			이어지게된다. 
			 */
			System.out.println("예외가 발생했어요");
			System.out.println("예외메세지:"+ e.getMessage());
			e.printStackTrace();
		}
		System.out.println("0번방 재출력:"+ intArr[0]);
		System.out.println("==ArrayIndexOutOfBoundsException발생후==");
	
	 
		/*
		숫자형식의 문자열을 int형으로 변환하는 경우 해당 문자열이
		숫자형식이 아닐때 발생되는 예외
		 */
		System.out.println("### NumberFormatException ###");
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("나이를 입력하세요:");
			String strAge = sc.nextLine(); //<= "10살" 형태로 입력
			int ageAfter10 = Integer.parseInt(strAge) + 10;//예외발생
			System.out.println("당신의 10년후 나이는:"+ ageAfter10);//실행되지않음
		}
		catch(NumberFormatException e) {
			System.out.println("나이는 숫자로만 입력해야 합니다.");
			System.out.println("예외메세지:"+ e.getMessage());
			e.printStackTrace();
		}

		
		/*
		숫자를 입력해야 되는데, 문자열을 잘못 입력하는 경우 발생되는 예외 
		 */
		System.out.println("### InputMismatchException ###");
//		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("나이를 입력하세요:");
			int intAge = sc.nextInt();//<= 문자를 입력하면 예외발생
			int ageAfter10 = intAge + 10;
			System.out.println("당신의 10년후 나이는:"+ ageAfter10);
		}
		catch(InputMismatchException e) {
			System.out.println("나이를 문자형태로 입력하면 앙데요");
			System.out.println("예외메세지:"+e.getMessage());
			e.printStackTrace();
		}
		
	
		
		/*
		인스턴스 변수에 참조값이 없는 상태에서 호출하면 발생되는 예외.
		즉 참조변수만 생성하고, 참조할 객체가 없는 상태에서 사용하면 
		발생하게된다. 
		 */
		System.out.println("### NullPointerException ###");
		System.out.println("toDay="+ toDay);/*
								여기서는 예외가 발생하지 않는다. 
								null이 문자열과 합쳐져서 단순히 출력만된다.
		 					*/ 
		try {			 
			System.out.println(toDay.getTime());/*
								예외는 여기에서 발생한다. null인 상태에서
								메소드를 호출할 수 없기때문이다. 
			 			*/
		}
		catch(NullPointerException e) {
			System.out.println("toDay 참조변수는 null입니다.");
			System.out.println("예외메세지:"+ e.getMessage());
		}
		
		/*
		ArithmeticException : 수학적 계산이 불가능한 경우 발생되는 예외
		 */
		System.out.println("### ArithmeticException ###");
		int result = 10;
		try {
			result = result / 0;//0으로는 숫자를 나눌수 없다. 무한대가 됨.
			System.out.println("결과는:"+ result);
		}
		catch(ArithmeticException e) {
			System.out.println("0으로 나눌수 없습니다.");
			System.out.println("예외메세지:"+ e.getMessage());
		}


		/*
		ClassCastException : 형변환이 불가능한 경우 발생되는 예외
		 */
		Object object = new Object();
		try {
			//순수한 Object객체이므로 다른 형으로 형변환할수 없다.
			String strObject = (String)object;
		}
		catch(ClassCastException e) {
			System.out.println("형변환 할 수 없습니다.");
			System.out.println(e);
			System.out.println(e.getMessage());
			e.printStackTrace();//<-개발시 가장 많이 사용함
		}
		System.out.println("==ClassCastException발생후==");
			
		System.out.println("끝~~~");
		
		String str = "형변환되나요?";
		boolean castFlag = myClassCasting(str);
		if(castFlag==true)
			System.out.println("됩니다요..");
		else
			System.out.println("안되네요..ㅜㅜ;");
				 
	}////end of main	
	/*
	String객체가 인자로 전달되면서 매개변수를 통해 Object로
	형변환되기 때문에 여기에서 상속관계가 확인되어 매개변수 o는
	String으로 형변환이 가능해지게 된다.
	 */
	public static boolean myClassCasting(Object o) {
		if(o instanceof String) {
			return true;
		}
		else {
			return false;
		}
	}
}




