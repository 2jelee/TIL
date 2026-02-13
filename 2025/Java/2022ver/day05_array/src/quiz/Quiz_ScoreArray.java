package quiz;

import java.util.Scanner;

public class Quiz_ScoreArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		  
		System.out.print("학생 수를 입력하세요. : ");
		
		//1차원배열
		String[] name = new String[sc.nextInt()];
		int[] kor = new int[name.length];
		int[] eng = new int[name.length];
		int[] com = new int[name.length];
		int[] tot = new int[name.length]; 
		double[] avg = new double[name.length];
		char[] grade = new char[name.length]; 
		
		for(int i=0; i<name.length; i++) { 
			System.out.print("학생 이름 입력 : ");
			name[i] = sc.next();
			
			System.out.print("국어 점수 입력 : ");
			kor[i] = sc.nextInt();
			
			System.out.print("영어 점수 입력 : ");
			eng[i] = sc.nextInt();
			
			System.out.print("수학 점수 입력 : ");
			com[i] = sc.nextInt();
			
			tot[i] = kor[i] + eng[i] + com[i];
			avg[i] = tot[i] / 3.0;
		
			switch (((int)avg[i])/10) {
				case 9:
				case 8:
					grade = 'A';
					break;
				case 70:
					grade = 'B';
					break;
				case 60:
					grade = 'C';
					break;
				case 50:
					grade = 'D';
					break;
				default:
					grade = 'F';
					break;
			}
			
			for(int j=0; j<name.length; j++) {
				System.out.println(name + "님의 성적표");
				System.out.println("국어:"+kor+"영어:"+eng+"전산:"+com);
				System.out.printf("총점 : %d 평균 : %.2f %c 학점 ", tot,avg,grade); 
			}
		}
	}
}
