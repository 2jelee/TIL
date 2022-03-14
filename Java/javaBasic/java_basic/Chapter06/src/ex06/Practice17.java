package ex06;

import java.util.Arrays;

/*
 * 다음과 같이 정의된 메서드를 작성하고 테스트 하시오.
 * 
 * 메서드명 : shuffle
 * 기능 : 주어진 배열에 담긴 값의 위치를 바꾸는 작업을 반복하여 뒤섞이게 한다. 처리한 배열을 반환한다.
 * 반환타입 : int[]
 * 매개변수 : int[] arr - 정수값이 담긴 배열
 * 
 * 결과
 * [1, 2, 3, 4, 5, 6, 7, 8, 9]
 * [4, 6, 8, 3, 2, 9, 7, 1, 5]
 */

public class Practice17 {
	/*
	int arr[] = new int[9];
	//생성자
	public Practice18() {};
	
	// shuffle 메서드를 작성하시오.
	int shuffle(int[] arr) {
		this.arr = arr;
		
		return Arrays.sort(arr);
	}
	*/
	
//	public static int[] shuffle(int[] arr) { 
	static int[] shuffle(int[] arr) { 		// 반환타입 : int[]
		if(arr==null || arr.length==0) {	// 배열 arr에 값이 없거나 길이가 0이면 arr을 반환한다. << 넘겨받은 배열이 null이거나 크기가 0이면 그대로 반환한다.
			return arr;						// 이유? 매개변수로 어떤 값이 넘어올지 모르기 때문에 '작업을 시작하기 전에 값의 유효성 체크가 반드시 필요'.
		}
		for (int i = 0; i < arr.length; i++) {	    	//반복문을 이용해서 반복적으로 배열의 임의의 두 요소의 값을 바꾼다.
			int j = (int)(Math.random()*arr.length);
			
			//arr[i]d와 arr[j]의 값을 서로 바꾼다.
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] original = {1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(java.util.Arrays.toString(original));
		
		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
	}
}
