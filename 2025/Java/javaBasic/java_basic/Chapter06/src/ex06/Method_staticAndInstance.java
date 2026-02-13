package ex06;

class MyMath2{
	long a, b;
	
	long add() {
		return a+b;
	}
	long sub() {
		return a-b;
	}
	long multi() {
		return a*b;
	}
	double divi() {
		return a/b;
	}
	
	static long add(long a, long b) {
		return a+b;
	}
	static long sub(long a, long b) {
		return a-b;
	}
	static long multi(long a, long b) {
		return a*b;
	}
	static double divi(long a, long b) {
		return a/(double)b;
	}
}

public class Method_staticAndInstance {
	public static void main(String[] args) {
		//클래스 메서드 호출, 인스턴스 생성없이 호출 O
		System.out.println("Class Method(static method) 호출 : "+MyMath2.add(200L, 100L));
		System.out.println("Class Method(static method) 호출 : "+MyMath2.sub(200L, 100L));
		System.out.println("Class Method(static method) 호출 : "+MyMath2.multi(200L, 100L));
		System.out.println("Class Method(static method) 호출 : "+MyMath2.divi(200L, 100L));
		
		//인스턴스 메서드는 객체 생성 후에만 호출 O
		MyMath2 mm = new MyMath2();
		mm.a = 200L;
		mm.b = 100L;		
		System.out.println("Instance Method 호출 : "+ mm.add());
		System.out.println("Instance Method 호출 : "+mm.sub());
		System.out.println("Instance Method 호출 : "+mm.multi());
		System.out.println("Instance Method 호출 : "+mm.divi());
	}
}
