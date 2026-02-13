package ex01;

public class MainEntry {
	public static void main(String[] args) {
		Calc c = new Calc();
		
		System.out.println(c.add(3, 4));
		System.out.println(c.add(100, 50));
		
		System.out.println();
		
		System.out.println(c.mul(3, 5));
		System.out.println(c.mul(10, 20));
	}
}
