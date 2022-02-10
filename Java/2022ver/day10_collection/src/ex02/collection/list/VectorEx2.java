package ex02.collection.list;

import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

public class VectorEx2 {
	public static void main(String[] args) {
		int i;
		Date date = new Date();
		Vector v = new Vector(3,5);
		
		v.addElement("java");			//string
		v.addElement(new Double(10.2)); //double
		v.addElement(date);				//object_객체 타입
		
		System.out.println("----------------3개 객체 추가--------------------");
		//초기 사이즈와 용량 확인 
		System.out.println("size : "+v.size()+", capacity : " +v.capacity());
		for (i = 0; i < 10; i++) {
			v.addElement(new Integer(i));
		}
		
		System.out.println(v);
		v.set(0, "java"); 	//교체(변경)
		System.out.println(v);
		
		System.out.println("----------------10개 객체 추가--------------------");
		System.out.println("size : "+v.size()+", capacity : " +v.capacity());

		System.out.println("----------------Vector 내용 출력--------------------");
		v.elements();	//type : enumeration 이므로 아래 코드작성
		Enumeration enu =v.elements();
		
		while (enu.hasMoreElements()) {
			System.out.print(enu.nextElement()+ "  \n");
		}

		System.out.println("----------------객체 내용 포함 확인--------------------");
		if(v.contains("java")) {
			System.out.println("java 문자열 포함됨");
		} else System.out.println("java 문자열 포함되지 않음");
		
		System.out.println("10.2 객체의 위치는? : " + v.indexOf(new Double(10.2)));	//결과 : index값이 0부터 시작하므로 1번
		System.out.println("10.2 객체의 위치는? : " + v.indexOf(10.2));
		
		//위치를 안다면
		System.out.println(v.get(2));
		//위치를 모른다면
		System.out.println(v.get(v.indexOf(date)));
		System.out.println();
		
		// date 객체 삭제
		v.removeElementAt(v.indexOf(date));
		System.out.println("size : "+v.size()+", capacity : " +v.capacity());
		System.out.println(v);
		
		for (i = 0; i < v.size(); i++) {
			v.removeElementAt(i);			//<< 다 지워지는 것이 X. 빈 배열이 삭제되면서 index번호가 변경이 되는(땡겨짐) 것임.
		}
		System.out.println("size : "+v.size()+", capacity : " +v.capacity());
		System.out.println(v);		// 결과 : [10.2, 1, 3, 5, 7, 9] 
		
		/***************************************/
		/*
		for (i = 0; i < v.size(); i++) {
			v.remove(0);			 
		}
		System.out.println("size : "+v.size()+", capacity : " +v.capacity());
		System.out.println(v);		 
		*/
		/***************************************/
		/*
		for (i = 0; i < v.size(); i++) {
			v.removeAllElements();			 
		}
		System.out.println("size : "+v.size()+", capacity : " +v.capacity());
		System.out.println(v);		 
		*/
		/***************************************/
		/*
		for (i = 0; i < v.size(); i++) {
			v.remove(10.2);			 
			//v.remove("java");			 
		}
		System.out.println("size : "+v.size()+", capacity : " +v.capacity());
		System.out.println(v);		 
		System.out.println("\n\n");		 
		
		v.trimToSize();
		System.out.println("size : "+v.size()+", capacity : " +v.capacity());
		
		v.removeAllElements();
		System.out.println("size : "+v.size()+", capacity : " +v.capacity());
		*/
		 
		/***************************************/
		
	}
}
