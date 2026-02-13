package test;

import java.util.Random;

public class Lotto {

	public static void randomCreate(int[] arr) {
		Random random = new Random();
		for(int i=0 ; i<arr.length ; i++) {
			arr[i] = random.nextInt(45)+1;
		}
	}
	public static void showArray(int[] arr) {
		for(int i=0 ; i<arr.length ; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	public static void main(String[] args) {
		
		int[] lottoNum = new int[6];
		//난수생성 및 중복검사
		randomCreate(lottoNum);
		//배열출력
		showArray(lottoNum);
	}
}
