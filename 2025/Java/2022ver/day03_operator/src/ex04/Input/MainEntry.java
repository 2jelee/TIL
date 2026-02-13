package ex04.Input;

//import java.lang.*;		//java lang 패키지는 자동 import 해준다. (그외에는 모두 import 시켜야한다.)
//import java.util.*;		//* : 전체
import java.util.Scanner;	//util 패키지에서 특정 선택하여 가져오기

public class MainEntry { 			//public class MainEntry extends Object { 와 동일 (java의 최상위 = Object)
	public static void main(String[] args) {
		System.out.println("Hi~");
		
		Scanner sc = new Scanner(System.in);	//Ctrl+Shift+o : 자동 import		//여기서 sc는 변수라고 부르며(이는 객체변수_instance object) stack영역에 저장됨
												// System크기는 4byte
												// 'new' 를 사용함으로써 동적메모리 할당
		
//		int x = 2;								// int type >> 메모리 크기 4byte
//		double y = 12.34;						// double type >> 8byte
//		char ch = 'B';							// char type >> 1byte
		
		System.out.println("integer, double, char data input 순서로 입력");
		
		int x = sc.nextInt();
		double y = sc.nextDouble();
//		String str = sc.next~
		char ch = sc.next().charAt(0);			//0번째에 있는 값을 가져와서 넣어라.	 ex) KOREA >> 0에 K가 들어간다.
		
		System.out.println(x + ", " + y + ", " + ch);	// Console에 Terminate에 빨간불 >> 입력대기중!
	}
}
