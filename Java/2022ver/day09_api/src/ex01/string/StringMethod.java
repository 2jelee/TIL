package ex01.string;

public class StringMethod {
	public static void main(String[] args) {
		
		String s1 = "2jelee";
		String s2 = "INCHEON";
		
		System.out.println(s2.hashCode());	//정수형태로 보여주는	| 결과 : -1634544550
		System.out.println(s2.replace("EO", "Korea"));
		System.out.println(s2);
		System.out.println(s2.hashCode());	//-1634544550 주소 같다.
		
		//실제 주소가 바뀌길 원한다면?
		s2 = s2.replace("EO", "Korea");		// replace -> 문자열 변경
		System.out.println(s2);				//글자가 변경되면 주소도 바뀐다
		System.out.println(s2.hashCode());	//결과 : 1825013198
		System.out.println();
		s1 = s1 + s2;
		System.out.println(s1);
		
		System.out.println("=========================================");
		
		String s3 = new String(" 	ab	cd		");
		System.out.println(s3);
		System.out.println(s3.length());  //문자열 길이
										  //trim : 양쪽에 대한 공백만 제거
		s3 = s3.trim();		//공백제거
		System.out.println(s3);
		System.out.println(s3.length());
		
		System.out.println("=========================================");
		
		String s4 = new String("ab defgh 23444 keirw 99348");
		String[] s5 = s4.split(" ");
		//배열이니까 for문 사용
		for (int i = 0; i < s5.length; i++) {		//s5 배열 .length 필드
			System.out.println("분리된 : " + i + "번 문자열 : " + s5[i]);
		}
		
		System.out.println();
		
		String s6 = new String("ab/defgh/23444/keirw/99348");
		String[] s7 = s6.split("/");
		for (int i = 0; i < s7.length; i++) {		//s5 배열 .length 필드
			System.out.println("분리된 : " + i + "번 문자열 : " + s7[i]);
		}
		
		System.out.println("=========================================");

		String s8 ="12345672jelee 45645678 recdsx 9895422 string";
		int n = s8.indexOf('5');		//문자 5가 있는 값의 위치를 알고 싶다.	※단, 여러개가 존재할 경우 처음 만나는 하나의 위치만 가져온다.
		System.out.println(n);
		System.out.println(s8.indexOf('r'));
		System.out.println(s8.lastIndexOf('5'));		//뒤에서부터 센다.
				
		System.out.println("=========================================");
		
		char ch = s8.charAt(24);		//24번째에 있는 문자를 보여줘
		System.out.println(ch);			
		System.out.println(s8.charAt(33));
		
		s8 = s8.substring(3);		//3번 인덱스부터 끝까지 출력
		System.out.println(s8);
		
		s8 = s8.substring(5, 7); //시작값 포함, 끝값(7)은 미포함
		System.out.println(s8);
		
		System.out.println("=========================================");
		
		System.out.println("소문자로 출력 toLowerCase() : " + s2.toLowerCase());
		System.out.println("대문자로 출력 toUpperrCase() : " + s1.toUpperCase());
		
		System.out.println(s1.length());		
		
		System.out.println(s1.length());
		char[] ch2 = s1.toCharArray();	//배열형태로 바꾸기 : toCharArray
		for (int i = 0; i < ch2.length; i++) {		// ch2.length
			System.out.print(ch2[i] + "\t");		// \t
		}
		System.out.println();
		
		for (int i = 0; i < s1.length(); i++) {		//위 for문과 결과는 동일하나 s1을 호출하는 경우 .length()임에 주의!
			System.out.print(ch2[i] + "\t");	  
		}
		
		
		
		
		
		
		/*****************************************/
		/*
		System.out.println();
		
		String str = "abc";
		System.out.println(str);
		System.out.println(str.concat("def"));	// .concat : 문자열 결합
		str = str.concat("def");
		System.out.println(str);
		
		System.out.println(str = "ijhe28782");
		String msg = "3284293482";
		System.out.println(str + msg);
		*/
	}
}
