package ex02.dataType;

public class MainEntry {
	
	static int Num; //**static이 붙으면 이탤릭체. static이 있는 것들은 초기화 안해도 된다. //**정수형 : 0 | 실수형 : 0.0 | 문자열 : NULL로 초기화 됨.
	static String str;
	
	public static void main(String[] args) {
		boolean b = true;
//		int x = b; // X 형변환 안된다!
		int x = 30;
		int y = 2222; // **지역변수는 반드시 초기화 하고 사용한다.
		
		int su = 99;
		
		System.out.println(b); //1bit
		System.out.println(x); //4byte
		System.out.println(y); //지역변수(local variable)을 초기화 하지 않으면 안되므로 error
		System.out.println(Num);
		System.out.println(str);
		System.out.println(x + ", " + y + ", " + su);
		
		System.out.println(1000); //int형
		System.out.println(1000L); // L(대/소문자 상관 X)을 붙이면 long타입으로 바뀜
		
		double dd = 12.34;
		System.out.println(dd);
		System.out.println(345.6789); //double
		
//		float ff = 12.34; //error 	>> 해당 compile 방향은 우에서 좌로. 이 경우, 12.34를 double로 인식함.
		float ff = 12.34f; //접미사 f(or F)를 붙임으로써 해결
		System.out.println(ff); //float
		
		System.out.println(5.5F); //4byte
		
		System.out.println("-------------------");
		short sh = 32767; // -32768 ~ 32767		>> 절대 자기 크기를 벗어나지 않는다.
		int i = 32769; // -32768 ~ 32767
		
		sh = (short)i; // 명시적 형변환
		System.out.println(sh);
		
	} // { }(block)안에 있는 애들 : local variable
}
