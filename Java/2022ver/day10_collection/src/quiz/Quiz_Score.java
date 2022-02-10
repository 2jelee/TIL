package quiz;

import java.util.Scanner;

class Score{
	String name;
	int kor, eng, com;
//	int tot;
//	double avg;
	
	public Score(String name, int kor, int eng, int com) {
		Scanner sc = new Scanner(System.in);
		name = sc.next();
		kor = sc.nextInt();
		eng = sc.nextInt();
		com = sc.nextInt();
	} 
}

public class Quiz_Score {
	public static void main(String[] args) {
		Calc cal = new Calc();
		System.out.println(tot);
	}
	
	
}
