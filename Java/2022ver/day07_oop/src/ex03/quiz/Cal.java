package ex03.quiz;

import java.util.Scanner;

public class Cal {
	//멤버변수
	double circle, triangle;
	
	public Cal(){
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		double circle = r * r * 3.14; 
	}

	public double getCircle() {
		return circle;
	}

	public void setCircle(double circle) {
		this.circle = circle;
	}

	public double getTriangle() {
		return triangle;
	}

	public void setTriangle(double triangle) {
		this.triangle = triangle;
	}
	 
}
