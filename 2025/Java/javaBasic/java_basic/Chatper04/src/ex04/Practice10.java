package ex04;

import java.util.Scanner;

/*
 * 숫자맞히기 게임을 작성한 것.
 * 1~100 사이의 값을 반복적으로 입력해서 컴퓨터가 생각한 값을 맞히면 게임이 끝난다.
 * 사용자가 값을 입력하면 컴퓨터는 자신이 생각한 값과 비교해서 결과를 알려준다.
 * 사용자가 컴퓨터가 생각한 숫자를 맞히면 게임이 끝나고 몇 번만에 숫자를 맞혔는지 알려준다.
 * 해당 코드를 완성하시오.
 */

public class Practice10 {
	public static void main(String[] args) {
//		int answer = (int)(Math.random());
		int answer = (int)(Math.random()*100)+1;
		int input = 0;
		int count = 0;
		
		Scanner sc = new Scanner(System.in);
		do {
			count++;
			System.out.print("1~100 사이의 값을 입력하시오 : ");
			input = sc.nextInt();
	
			if(answer==input) {
				System.out.println("정답입니다.");
				System.out.println("총 도전 횟수는 "+count+"번 입니다.");
				break;
			} else if (answer > input) {
				System.out.println("값이 너무 작습니다. 다시 입력하세요.");
				continue;
			} else if (answer < input) {
				System.out.println("값이 너무 큽니다. 다시 입력하세요.");
				continue;
			}
		} while(true);
	}
}
