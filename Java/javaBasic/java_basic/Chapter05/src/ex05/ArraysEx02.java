package ex05;

public class ArraysEx02 {
	public static void main(String[] args) {
		int[] score = {79, 88, 91, 33, 100, 55, 95};
		
		//scorea 배열의 첫번째 값으로 초기화
		int max = score[0];
		int min = score[0];
		
		//왜 for문 초기값을 1로 했을까? => index가 0인 것이 아닌, 두번째 요소부터 읽기 위해!
		for (int i = 1; i < score.length; i++) {
			if(score[i] > max) {
				max = score[i];
			} else if (score[i] < min) {
				min = score[i];
			}
		}
		
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
	}
}
