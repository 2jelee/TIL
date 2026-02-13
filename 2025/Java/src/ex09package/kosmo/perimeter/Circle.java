package ex09package.kosmo.perimeter;

//원의 둘레를 계산하기 위한 클래스
public class Circle {
	double rad;
	final double PI;
	
	public Circle(double rad){
		this.rad = rad;
		PI = 3.14159;
	}	
	public double getPerimeter(){	
		return 2 * PI * rad;
	}
}
