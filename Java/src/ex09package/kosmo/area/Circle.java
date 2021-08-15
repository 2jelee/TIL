package ex09package.kosmo.area;

//원의 넓이를 계산하는 클래스
public class Circle {
	double rad;
	final double PI;
	
	public Circle(double rad){
		this.rad = rad;
		PI = 3.14159;
	}	
	public double getArea(){	
		return PI * rad * rad;
	}	
}
