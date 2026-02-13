package ex08.api;

import java.util.Scanner;

/*
 * java에서의 최상위 >> Object
 * Object 클래스가 가지고 있는 것 알아보기
 */

class Point{
	
}

public interface OjectClass {
	public static void main(String[] args) {
		//instance 생성
		Point p = new Point();
//		System.out.println("Point p information");
		System.out.println("Point class name : "+ p.getClass());	//point 클래스의 full name이 출력됨
		System.out.println("Scanner class name : "+new Scanner(System.in).getClass());

		//주소가 16진수 형태로 출력됨
		System.out.println("hashCode(선언되어 있는 주소) : " + p.hashCode());
		
		//주소가 16진수 형태로 출력됨
		System.out.println("Object String : " + p.toString());	
		System.out.println("Object String : " + p);				//위 두 가지는 결국 같다 => 내부적으로 toString이 있었다?
		
		System.out.printf("10진수 %d\n", 0x7d4991ad);	//16진수의 형태를 출력하기 => 0x 붙이면 됨
		
		System.out.println("======================================================================");
		//객체는 무조건 4byte를 가진다.
		
		//instance 생성
		Point p2 = new Point();
//				System.out.println("Point p information");
		System.out.println("Point class name : "+ p2.getClass());	//point 클래스의 full name이 출력됨
		System.out.println("Scanner class name : "+new Scanner(System.in).getClass());

		//주소가 16진수 형태로 출력됨
		System.out.println("hashCode(선언되어 있는 주소) : " + p2.hashCode());
		
		//주소가 16진수 형태로 출력됨
		System.out.println("Object String : " + p2.toString());	
		System.out.println("Object String : " + p2);				//위 두 가지는 결국 같다 => 내부적으로 toString이 있었다?
		
		System.out.printf("10진수 %d\n", 0x28d93b30);	//16진수의 형태를 출력하기 => 0x 붙이면 됨
		
		System.out.println("======================================================================");

		//p2의 의미를 확인해보기		 ex08.api.Point@28d93b30
		System.out.println("p2.toString() : toString()의 의미");
		System.out.println(p2.getClass().getName()+'@'+Integer.toHexString(p2.hashCode()));	//Integer.toHexString : 16진수 형태로 보여주는 형변환작업
		
		System.out.println("======================================================================");
		
		Point p3 = new Point();
		if(p.hashCode() == p3.hashCode()) {
			System.out.println("주솟값 같다");
		} else System.out.println("주솟값 다르다");
		
	}
}
