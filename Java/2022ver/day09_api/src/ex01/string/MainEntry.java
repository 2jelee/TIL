package ex01.string;

/*
[기본형 타입(Primitive type)]
-논리형
-정수형
-실수형
-문자형

총 8가지의 기본형 타입(Primitive type)을 미리 정의하여 제공한다.
기본값이 있기 때문에 Null이 존재하지 않는다. 
만약 기본형 타입에 Null을 넣고 싶다면 래퍼 클래스를 활용한다.
실제 값을 저장하는 공간으로 스택(Stack) 메모리에 저장된다.
만약 컴파일 시점에 담을 수 있는 크기를 벗어나면 에러를 발생시키는 컴파일 에러가 발생한다. 
주로 문법상의 에러가 많다. 예를 들어 ;을 안붙였다는 이유로 빨간 줄이 쳐지는 경우


[참조형 타입(Reference type)]
-배열
-열거(Enumeration)
-클래스
-인터페이스

기본형 타입을 제외한 타입들이 모두 참조형 타입(Reference type)이다.
빈 객체를 의미하는 Null이 존재한다.
값이 저장되어 있는 곳의 주소값을 저장하는 공간으로 힙(Heap) 메모리에 저장된다.
문법상으로는 에러가 없지만 실행시켰을 때 에러가 나는 런타임 에러가 발생한다. 
예를 들어 객체나 배열을 Null 값으로 받으면 NullPointException이 발생하므로 변수값을 넣어야 한다.

출처 : https://gbsb.tistory.com/6
 */


public interface MainEntry {
	public static void main(String[] args) {
		String str = new String("korea");
		
		//primitive type
		int x = 99;
		double y = 12.34;
		String message = "hi!!";	//primitive type처럼 사용
		
		System.out.println(str);
		System.out.println(message);
		System.out.println(x+ ", "+ y);
		
		char data[] = {'a' , 'b', 'c'};
		String str2 = new String(data);
		System.out.println(data[1]);
	    for (int i = 0; i < data.length; i++) {
	    	System.out.print(data[i]+" ");
	    } 
	}
}
