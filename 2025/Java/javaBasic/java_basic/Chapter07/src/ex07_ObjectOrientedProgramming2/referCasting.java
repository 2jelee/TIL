package ex07_ObjectOrientedProgramming2;

/*
 * 참조 변수의 형변환
 */

class Car{
	String color;
	int door;
	
	void drive() {
		System.out.println("drive, Brrrrr-");
	}

	void stop() {
		System.out.println("stop!!!");
	}
}

class FireEngine extends Car{ //소방차
	void water() {
		System.out.println("water-!");
	}
}

public class referCasting {
	public static void main(String[] args) {
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		
		fe.water();
		car = fe; //car = (Car)fe; 에서 형변환 생략됨 (O)
//		car.water(); //컴파일 에러 -> Car 타입의 참조변수로는 water() 호출 불가 << water은 자손의
		
		fe2 = (FireEngine)car; //자손 타입 <- 조상 타입. 형변환 생략 X
		fe2.water();
		
	}
}
