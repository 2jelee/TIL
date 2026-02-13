package ex01.method;

public class MethodEx {
	
	//4) 매개변수 있고 리턴타입 있는 경우
	public static String name(String n) {
		return n;
	}
	
	public static String name(String n, int x) {
		String str = null;	//초기화
		
		for(int i=0; i<x; i++) {
			str += n+"\n";
		}
		return str;
	}
	
	public static void main(String[] args) {
		//책임소재는 호출하는 쪽
		String name = name("2jelee");
		System.out.println(name);
		
		System.out.println(name("gildiong"));
		
		System.out.println(name("kbs", 5));
	}
}
