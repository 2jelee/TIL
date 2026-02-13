package ex06;

class Data2 {
	int x;
}

public class PrameterReferenceType {
	public static void main(String[] args) {
		Data2 d = new Data2();
		d.x = 10;
		System.out.println("main() : x = " + d.x); //10
		
		change(d); // change메서드의 매개변수를 참조형으로 선언 => read & write!
		System.out.println("After change(d)");
		System.out.println("main()_change : x = " + d.x); //1000
	}
	
	static void change(Data2 d) {
		d.x = 1000;
		System.out.println("change() : x = " +d.x); //1000
	}
}
