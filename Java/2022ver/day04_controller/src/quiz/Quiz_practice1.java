package quiz;

/*
[과제1] 논리연산, 교환알고리즘, if문 이용

숫자 3개를 입력받는다.
ex)
	3
	4
	5

단, 어떠한 순서대로 넣더라도 큰 순서대로 출력하는 프로그램 작성.
	ex) 5 4 3
*/

import java.util.Scanner;

public class Quiz_practice1 {
	public static void main(String[] args) {
		System.out.println("숫자 3개를 입력해주세요.");
		int a = new Scanner(System.in).nextInt();
		int b = new Scanner(System.in).nextInt();
		int c = new Scanner(System.in).nextInt();
		int[] arr = new int[3];			//배열 생성
		arr[0] = a;
		arr[1] = b;
		arr[2] = c;
		
		int temp;	//임시 저장할 변수
		
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j] > arr[i]) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		System.out.println("큰 순서대로 정렬합니다.");
		for(int k = 0; k < arr.length; k++ ) {
            System.out.println(arr[k]);
        }
	}
}
