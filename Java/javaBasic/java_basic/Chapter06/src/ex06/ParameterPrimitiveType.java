package ex06;

class Data {
	int x;
}

public class ParameterPrimitiveType {
	public static void main(String[] args) {
		Data data = new Data();
		data.x = 10;
		System.out.println("main() : x = " + data.x); //10
		
		change(data.x); // 매개변수를 기본형으로 선언 => read Only!
		System.out.println("After change(data.x)");
		
		System.out.println("main()_change : x = " + data.x); //1000가 X => data.x의 값이 변경된 것이 아니라, change 메서드의 매개변수 x의 값이 변경된 것이다.
		// 즉, 원본이 아닌, 복사본이 변경된 것이므로 원본은 아무 영향 X. 이처럼 기본형 매개변수는 변수에 저장된 값만 읽을 수 있을 뿐, 변경 X
		// x가 int이므로 기본형의 정수형이다. <= Primitive Type
	}
	
	static void change(int x) {
		x = 1000;
		System.out.println("change() : x = " + x); //1000
	}
}
