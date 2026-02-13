package ex07.randomClass;

/*
[문제] Lotto 6개 번호(1~45까지) 추첨 단, 같은 수 나올 수 없다.

문제2] 로또 프로그램 작성 :   
   1 ~ 45 숫자 중에서 6개 추출 (단, 같은수 없어야함)

 */

public class Quiz_Lotto {
	public static void main(String[] args) {  
		int[] arr = new int[6];	//입력 받을 배열 선언 
		System.out.print("오늘의 당첨번호 : ");
		for(int i=0; i<arr.length; i++) {
			int lottoNum = (int)(Math.random()*45)+1;	//Lotto는 뽑는 값이 0이 나올 수 없다.	>> +1
			arr[i] = lottoNum;
			for(int j=0; j<i; j++) {
				if(arr[i] == arr[j]) {
					i--;
					break;
				}
			}
			System.out.print(arr[i]+ " ");
		}		
	}
}
