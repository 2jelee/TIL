package ex03.quiz;

import java.util.Scanner;

/*
 * [문제] class Draw { int w, h; double result; }
 * 
 * sub class : Circle 원의 넓이, Triangle 삼각형 넓이
 * 계산이 필요하면 cal 만들 O 
 * 
 * 메인클래스에서 
 */
public class Quiz_Draw { //Super class
	protected int w, h;
	protected double result;
	
	public Quiz_Draw() {
//		w = 10;
//		h = 5;
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		double circle = r * r * 3.14;
		 
		int w = sc.nextInt();
		int h = sc.nextInt();
		double triangle = w * h * 1/2;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}
	
	public void Cal_circle() {
//		double circle;
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		double circle = r * r * 3.14;
	}
	public void Cal_triangle() {
//		double triangle;
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		double triangle = w * h * 1/2;
	}
	
	public static void main(String[] args) {
		Quiz_Draw dr = new Quiz_Draw();
		dr.g
		
	}
}
