package ex04.constructor;

//defualt constructor / API 만들기

public class MainEntry {
	/**
	 * @param args 메인은 아무 값도 넘겨받지 않습니다.
	 * @param x 곱을 구하는 것에 첫 번째 정수형 변수
	 * @param y 곱을 구하는 것에 두 번째 정수형 변수
	 * @param gob 변수는 x와 y의 두 정수 곱을 저장하는 변수
	 */
	public static void main(String[] args) {
		int x, y, gob = 1;	//곱하는 변수는 절대 0으로 초기화 X
		String msg;
		char ch = 'A';
		
		x = 5; y = 10;
		msg = "DouZone Th2";
		
		gob = gob(x, y);
		
		System.out.println(ch);
		System.out.println(msg);
		System.out.println(x + " * " + y + " = " + gob);
	}

	private static int gob(int x, int y) { 
		return x * y;
	}
}
