package ex16exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
예외처리를 할 때 필요에 따라 여러개의 catch블럭을 사용할 수 있다.
이경우 반드시 자식 예외클래스부터 catch블럭을 사용해야한다.
Exception클래스는 모든 예외를 catch 하기때문에 반드시 
마지막 블럭에 사용해야한다.
특정 클래스의 상속구조를 보고 싶을때는 선택후 Ctrl+t로 확인할수있다.
 */
public class Ex04MultiCatch {

public static void main(String[] args) {
 
		Scanner scanner = new Scanner(System.in);
		int array[] = new int[3];		
		try {
			for(int i=0 ; i<array.length ; i++) {
				System.out.print("array["+ i +"]에 저장할 숫자입력:");
				array[i] = Integer.parseInt(scanner.nextLine());/*
					테스트시 '11a' 형태로 입력해볼것
				*/
			}

			System.out.println("배열에 저장된 두 숫자나누기:"+
					array[0]/array[1]); //array[1]에 0을 입력해볼것

			System.out.print("나이를 입력하세요:");
			int age = scanner.nextInt();//나이입력시 문자를 입력해볼것
			 
			System.out.println("당신의 나이는:"+ age);

			array[3] = age;//배열의 인덱스를 초과함.
		}		
		catch(InputMismatchException e) {
			System.out.println("숫자로만 입력해야 합니다.");
		}
		catch(ArithmeticException e) {
			System.out.println("산술연산이 불가능 합니다.");
		}
		catch(NumberFormatException e) {
			System.out.println("숫자형태의 문자만 입력가능합니다.");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 인덱스를 초과하였습니다");
		}
		catch(Exception e) {	
			System.out.println("예외가 발생하였습니다.");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("===프로그램 끝===");
	}

}
