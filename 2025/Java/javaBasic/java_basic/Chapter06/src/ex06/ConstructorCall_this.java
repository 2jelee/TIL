package ex06;

class Car2{
	String color;
	String gearType;
	int door;
	
	public Car2() {
		this("white", "auto", 4);
	}

	public Car2(String color) {
		this(color, "manual", 2);
	}
	
	public Car2(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}

public class ConstructorCall_this {
	public static void main(String[] args) {
		Car2 c1 = new Car2();
		Car2 c2 = new Car2("blue");
		
		System.out.println("c1의 color, gearType, door : "+c1.color+", "+c1.gearType+", "+c1.door);
		System.out.println("c2의 color, gearType, door : "+c2.color+", "+c2.gearType+", "+c2.door);
		
	}
}
