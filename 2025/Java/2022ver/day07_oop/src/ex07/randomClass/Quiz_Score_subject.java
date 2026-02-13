package ex07.randomClass;

import java.util.Scanner;

public class Quiz_Score_subject {
	protected int kor, eng, com, total;
	protected double avg;
	
//	public Quiz_Score_subject(int total, double avg) {
//		total = kor+eng+com;
//		avg = total/3.0;
//	}
	public Quiz_Score_subject() {
		total = kor+eng+com;
		avg = total/3.0;
	}
	
	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getCom() {
		return com;
	}

	public void setCom(int com) {
		this.com = com;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
	 
	@Override
	public String toString() {
		return "Quiz_Score_subject [total=" + total + ", avg=" + avg + "]";
	}

	public void point() {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어점수 입력 : ");		kor = sc.nextInt();
		System.out.print("영어점수 입력 : ");		eng = sc.nextInt();
		System.out.print("전산점수 입력 : ");		com = sc.nextInt(); 
		System.out.println("[성적표] 국어 : " +kor + "점 | 영어 : " + eng +"점 | 전산 : "+ com+"점");
//		Quiz_Score_subject subj = new Quiz_Score_subject();
//		subj.getTotal();
		System.out.println("합산점수 : "+(kor+eng+com)+ "점 | 평균 : " +(kor+eng+com)/(3.0)+"점");
	}
}
