package ex02.stringBuffer;

/*
 * [StringBuffer vs StringBuilder]
 * StringBUffer :
 * jdk 1. ~
 * thread 지원 O
 * 
 * StringBuilder : 
 * jdk 5.~
 * thread 지원 X
 * 
 */

public class MainEntry {
	public static void main(String[] args) {

		StringBuffer sb = new StringBuffer();
		
		System.out.println(sb.hashCode());				// ★★★주소값 : 366712642
		
//		StringBuffer sb = new StringBuffer("korea");
		System.out.println("length   /   capacity");
		System.out.println();

		int leng = sb.length();   int size = sb.capacity(); 
		System.out.println(leng  + "   /   " + size);
		 
		// append : 뒤에 추가
		sb.append("happyvirus");
		leng = sb.length();   size = sb.capacity();
		System.out.println(leng  + "   /   " + size);				// 10 / 16 
		
		sb.append("12345 67890");		// >> white space도 공간(문자)이다
		System.out.println(sb.length() + " / "+sb.capacity());		// 21 / 34
		
		sb.append("dldld wldms 123450");
		System.out.println(sb.length() + " / " + sb.capacity()); 	// 39 / 70
		
		System.out.println(sb.hashCode());			// ★★★주소값 : 366712642		>> 같은 주소값을 가지고 있다. 이는 메모리 낭비가 없음을 알 수 있다!
		
		System.out.println(sb);
		sb.trimToSize(); 	//용량 크기 조정
		System.out.println(sb.length() + " / " + sb.capacity());	// 39 / 39
		
	}
}
