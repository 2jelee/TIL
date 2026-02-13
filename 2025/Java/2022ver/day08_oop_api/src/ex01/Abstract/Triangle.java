package ex01.Abstract;

public class Triangle extends Shape2 {
	double x = 5.0;
	double y = 6.0; 
	double result2 = 0;

	@Override
	public double calc2() {
		result2 = x*y*(0.5);
		return result2;
//		return 0;
	}
	
	public void disp2() {}

	@Override
	public void draw2() {
		calc2();
		System.out.println("삼각형의 넓이 : " +result2+"인 삼각형");
	};
	
}
