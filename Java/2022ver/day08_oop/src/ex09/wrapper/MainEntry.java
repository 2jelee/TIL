package ex09.wrapper;

class Point { }

public interface MainEntry {
	public static void main(String[] args) {
		
		// Heap 영역에 있음
		Integer Ia = new Integer(10);
		Integer Ib = new Integer("10");
		String su = "30";
		
		Point pt = new Point();
		
		//아래 두 코드 결과값 같음(주소값 나옴)
		System.out.println(pt);
		System.out.println(pt.toString());
		System.out.println(pt.getClass().getName()+'@'+Integer.toHexString(pt.hashCode()));
		
		System.out.println();
		
		System.out.println(Ia);
		System.out.println(Ia.getClass().getName()+'@'+Integer.toHexString(Ia.hashCode()));	// [주의] a 출력됨  >>주소가 아니라 실제 data값이 나온다.
		 
		// Stack 영역에 있음
		int x = 77;
		double y = 5.5;
		System.out.println(x + ", "+y);
		
		x = (int)y;
		System.out.println(x +", " + y);
		
		// 저장되는 메모리 자체가 달라지는..
		// Boxing 	: stack -> heap 영역으로 갈 때
		// Unboxing : heap -> stack 영역으로 갈 때
		int c = Ia.intValue();	// jdk 4.x 이전에 사용하던 메소드
		int d = Ib;				// 자동형변환 발생 >> jdk 5.x 이후부터 autoboxing, unboxing 
		
		System.out.println("----------------------------");
		System.out.println(c+", "+d); 
		int num = Integer.parseInt(su);
		
		System.out.println(c+num);//
		System.out.println(c+d);
		System.out.println(Ia.MAX_VALUE);	//21(억)...
		System.out.println(Ia.MIN_VALUE);	//-21(억)...
		
		Double dd = new Double(12.34);
		System.out.println(dd);
		System.out.println(dd.MAX_VALUE);
		System.out.println(dd.MIN_VALUE);
		
		System.out.println("=========================");
		
//		c = (int)dd;	//error >> dd는 object 타입 c는 primitive 타입
		c = (int)dd.doubleValue();		// .XXX(자료형)Value();
		System.out.println(c);
		
		System.out.println("========================");
		
		int e = Integer.parseInt("123");
		int f = Integer.parseInt("1111111", 2);	//"1111111"(7개)를 2진수로 바꿔라
		System.out.println(e+20);		//143
		System.out.println(f);			//2^7.....?
		
		/******************************************/
		
		int xx = 3;
		
	}
}
