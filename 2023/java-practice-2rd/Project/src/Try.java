import java.util.InputMismatchException;
import java.util.Scanner;

public class Try {
	public static void main(String[] args)  {	
		
		System.out.println("### InputMismatchException ###");
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("나이를 입력하세요:");
			int intAge = sc.nextInt();//<= 문자를 입력하면 예외발생
			int ageAfter10 = intAge + 10;
			System.out.println("당신의 10년후 나이는 : "+ ageAfter10);
		}
		catch(InputMismatchException e) {
			System.out.println("나이를 문자형태로 입력하면 앙데요");
			System.out.println("예외메세지:"+e.getMessage());
			e.printStackTrace();
		}
	}
}
