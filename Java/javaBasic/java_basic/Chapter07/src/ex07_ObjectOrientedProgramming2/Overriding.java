package ex07_ObjectOrientedProgramming2;

/*
 * [오버로딩]
 * 기존에 없는 새로운 메서드를 추가 => new
 * 
 * [오버라이딩]
 * 상속받은 메서드의 내용을 변경 => change, modify
 * 메서드의 선언부(메서드명, 매개변수, 반환타입)이 조상의 것과 정확히 일치해야 한다.
 */

class Parent{
	void parentMethod() { };
}
public class Overriding extends Parent {

	void parentMethod() { } 	  // 오버라이딩
	void parentMethod(int i) { }  // 오버로딩
	
	void childMethod() { }	
	void childMethod(int i) { }   // 오버로딩
//	void childMethod() { }
	
}
