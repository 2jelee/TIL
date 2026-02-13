package ex01.method;

public class ArrayMethod {
	public static void main(String[] args) {
		int x = 3, y = 5;

		int result = MethodEx(x, y);
		System.out.println(result);
		
		int[] arrResult = MethodEx2();	//return 타입
		//System.out.println(arrResult);	>> [I@15db9742
		
		/*
		//일반 for문 사용
		for(int i=0; i<arrResult.length; i++) {
			System.out.println(arrResult[i] + " ");	//arrResult의 i번째 값
		}
		*/
		
		//확장 for문 사용
		for (int item : arrResult) {	
			System.out.println(item + " ");
		}
	}

	private static int[] MethodEx2() {	//배열타입
		int[] arr = {1,2,3,4,5,6,7,8};
		
		return arr;	//이는 배열로 선언된  [0]번째의 주솟값을 가지고 있다.
	}

	private static int MethodEx(int x, int y) {
		return x+y;	//받아온 x와 y를
	}
}
