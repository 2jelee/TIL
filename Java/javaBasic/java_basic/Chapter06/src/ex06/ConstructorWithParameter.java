package ex06;

class Car{
	String color;
	String gearType; //변속기 종류
	int door; //문의 갯수
	
	// default 생성자
	Car() { };
	
	// 매개변수가 있는 생성자
	Car(String c, String g, int d){
		color = c;
		gearType = g;
		door = d;
	}
	
}

public class ConstructorWithParameter {
	public static void main(String[] args) {
		Car c1 = new Car();
		c1.color = "white";
		c1.gearType = "auto";
		c1.door = 4;
		
		Car c2 = new Car("black", "manual", 2); //생성과 동시에 초기화
		
		System.out.println("c1의 color, gearType, door : " + c1.color+", " +c1.gearType+", " + c1.door);
		System.out.println("c2의 color, gearType, door : " + c2.color+", " +c2.gearType+", " + c2.door);
	}
}
