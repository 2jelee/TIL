package ex07_ObjectOrientedProgramming2;

class Parent_2 {
	int x = 10; // super.x;
}

class Child extends Parent_2{
	int x = 20; // this.x;
	
	void method() {
		System.out.println("x = " + x);
		System.out.println("this.x = " + this.x);
		System.out.println("super.x = " + super.x);
	}
}

public class Super {
	public static void main(String[] args) {
		Child c = new Child();
		c.method();
	}
}
