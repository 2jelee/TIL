package chapter02;

//두 변수 바꾸기

public class Var_temp {
	public static void main(String[] args) {
		int x=4, y=2;
		int temp;
		
		temp=x; //1. x의 값을 y에 저장
		x=y;	//2. y의 값을 x에 저장
		y=temp; //3. temp의 값을 y에 저장
		
		System.out.println("x의 값은 : " +x);
		System.out.println("y의 값은 : " +y);
	}
}

/*
 * [기본형과 참조형]
 * 기본형(Primitive type)
 * - 오직 8개 : 
 * 	 1. 논리형 : boolean
 * 	 2. 문자형 : char
 * 	 3. 정수형 : byte(1), short(2), int(4), long(8byte)
 * 	 4. 실수형 : float, double
 * - 실제 값을 저장
 * 
 * 참조형(Reference type)
 * - 기본형을 제외한 나머지(String, System 등)
 * - 메모리 주소를 저장(4byte or 8byte)
 * 		Date today;	//참조형 변수 today를 선언
 * 		today = new Date();	//today에 객체의 주소를 저장
 * 		ㄴ100번지 ㄴ 객체생성
 *  
 */
