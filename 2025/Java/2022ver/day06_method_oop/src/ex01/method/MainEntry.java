package ex01.method;

import java.util.Arrays;

/*
[함수(Method)]
메인함수 부담 줄이고, 반복적인 코드를 함수로 만들어서 사용
-instance method : 객체 생성하고 사용해야 한다.	
					>> 객체 생성 : 메모리상에 할당되어 있어야만 사용 가능
-static method : ★객체 생성없이 바로 사용 가능
					object.methodName();
					ClassName.methodName(); 	//주로

-매개변수의 유무 / 리턴타입의 유무
1) 매개변수 없고, 리턴타입 없는 경우
	public return Type methodName(){ }

2) 매개변수 있고, 리턴타입 없는 경우
	public return Type mehodName(parameter var1, parameter var2, ...) { }

3) 매개변수 없고, 리턴타입 있는 경우
	public returnType methodName(0 { return value; }
	ex) public int show() { return intValue; }

4) 매개변수 있고, 리턴타입 있는 경우
	public returnType methodName(parameter var1, ...){
		return value;
	}
	ex) public String name(String irum, int x){
			String msg = irum + x;
			//return irun;
			return msg;
	
*/

import java.util.Scanner;

public class MainEntry {
	
	/*
	//1) 매개변수 없고, 리턴타입 없는 경우
	public static void namePrint() {
		System.out.println("2jelee");
	}
	
	//return타잆이 없으면 void이다.
	public static void main(String[] args) {
		namePrint(); //main에서 함수 호출(몇번이고 호출 가능)
		namePrint();
		
//		int[] a = {1,2,3,4,5,6,7};
//		Scanner sc; //이는 객체 선언만 했을뿐 메모리에 할당하지 않았다.
//		sc = new Scanner(System.in);	//객체 생성, 메모리에 할당, 생성자함수 자동호출
//		int kor = sc.nextInt();
//		System.out.println(kor);
//		
//		Arrays.sort(a);
		
	}
	*/
	
	/*
	//2) 매개변수 있고, 리턴타입 없는 경우
	public static void add(int x, int y) {
		int sum = x + y;
		System.out.println("sum : " + sum);
	}
	
	public static void main(String[] args) {
		add(1,3);
		add(10,30)
	}
	*/
	
//	/*
	//3) 매개변수 없고, 리턴타입 있는 경우
//	public static int plus() {
	public static int plus(String y) {
		int result = 300;	//main의 result변수와 다르다. >> local variable임(생존범위는 블럭 내부)
//		return 1000;
		return result;
//		return 2+3-5*7;
	}
	
	//리턴타입과 매개변수 있는 경우	>> 만약 public static double plus() { 면 함수명이 같으므로 X
	public static double plus(int x) {	//매개변수의 자료형으로 		//2. 해당 함수는 double 타입
		int sum = x + 100;
//		return 12.3;
		return sum;		//1. 해당 return하는 타입은 int
	}
	
	public static void main(String[] args) { 	//return Type인 경우, 호출하는 곳에서 출력의 책임이 있다.
		System.out.println(plus(10)); //3. 결과 : 110.0		>> return하는 타입보다 해당 함수의 타입이 우선순위가 높다
		
//		int result = plus(5);
//		System.out.println(result);
		
//		System.out.println(plus());
//		int result= plus();
//		System.out.println(result);
	}
//	*/
}
