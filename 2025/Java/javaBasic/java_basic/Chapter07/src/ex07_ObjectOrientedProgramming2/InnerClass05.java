package ex07_ObjectOrientedProgramming2;

class Outer3{
	int value = 10; //Outer3.this.value
	
	class Inner{
		int value=20; //this.value
	
		void method1() {
			int value = 30;
			System.out.println("             value : " +value);
			System.out.println("        this.value : " + this.value); //여기서 this는 class Inner의 변수를 지칭
			System.out.println(" Outer3.this.value : " + Outer3.this.value);
		}
	}
}

class InnerClass05 {
	public static void main(String[] args) {
		Outer3 outer = new Outer3();
		Outer3.Inner inner = outer.new Inner();
		inner.method1();
	}
}
