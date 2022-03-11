package ex05;

import java.util.Scanner;

/*
 * 단어의 글자위치를 섞어서 보여주고 원래의 단어를 맞추는 예제이다.
 * 실행결과와 같이 동작하도록 예제의 빈 곳을 채우시오.
 */

public class Practice06 {
	public static void main(String[] args) { 
		String[] words = {"television", "computer", "mouse", "phone"};
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < words.length; i++) {
			char[] question = words[i].toCharArray(); //String을 char로 변환
			
			//구현해서 완성하시오. char배열 question에 담긴 문자의 위치를 임의로 바꾼다.
//			System.out.println(question);
			for (int j = 0; j < question.length; j++) {
				int idx = (int)(Math.random() * question.length);
				
				char temp = question[i];
				question[i] = question[idx];
				question[idx] = temp;
			}
			 
			System.out.printf("Q%d. %s의 정답을 입력하시오. : ", i+1, new String(question));
			
			String answer = sc.nextLine();
			
			// trim()으로 answer의 좌우공백을 제거한 후, equals로 word[i]와 비교
			if (words[i].equals(answer.trim())) {
				System.out.printf("맞았습니다. %n%n");
			} else {
				System.out.printf("틀렸습니다. %n%n");
			}
		}
	}
}
