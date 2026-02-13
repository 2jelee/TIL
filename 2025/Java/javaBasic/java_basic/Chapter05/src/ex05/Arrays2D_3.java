package ex05;

import java.util.Scanner;

public class Arrays2D_3 {
	public static void main(String[] args) {
		String[][] words = {
								{"chair", "의자"},
								{"computer", "컴퓨터"},
								{"integer", "정수"}
							};
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < words.length; i++) {
			System.out.printf("Q%d. %s의 뜻은?", i+1, words[i][0]);
			
			String temp = sc.nextLine();
			
			if(temp.equals(words[i][1])) {
				System.out.printf("정답! %n%n");
			} else {
				System.out.printf("오답! 정답은 %s였습니다. %n%n", words[i][1]);
			}
		}
	}
}
