package ex03.quiz;

import java.util.Scanner;

public class Quiz_Triangle extends Quiz_Draw_solv {

	public Quiz_Triangle() {
		Scanner sc = new Scanner(System.in);
		System.out.print("넓이 : ");
		this.w = sc.nextInt();
		System.out.print("높이 : ");
		this.h = sc.nextInt();		
	}

	@Override
	public double calc() {
		this.result = (w*h) / 2.0;		//정수데이터 연산
//		return super.calc(); 	//여기서 super는 draw
		return result;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();	
		/*
		super : Quiz_Draw_solv 의
		@Override
		public String toString() {
			return "Quiz_Draw_solv [w=" + w + ", h=" + h + ", result=" + result + "]";
		}
		*/
	}

	@Override
	public void show() {
		System.out.println(w + ", " + h + ", result = " + calc());
		//		super.show();
	} 
}
