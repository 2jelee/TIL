package ex02.Abstract;

public abstract class Shape { //Super class
//	double result =0;
	protected double result =0;	//MultiClass에서 extends 받기 위해 protected로 했음
	
	//명시적으로 보이게?
	public abstract double calc(double x);	//abstract method
//	public abstract void show();			//abstract method
	
	// Triangle.java에서 name 호출하므로 코드 추가
	public abstract void show(String name);			//abstract method
	
	public void view() {
		System.out.println("Super class Shape");
	}
}
