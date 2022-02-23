package etc_FEB.book;
 

/*
 * [배열의 모든 요소의 합계 구하기]_확장 for문 사용
 * 
 * 배열을 다룰 때는 거의 대부분 for문을 사용
 * 이 for문을 기본 for문(basic of statement)이다.
 * 또 다른 for문인 확장for문(enhanced for statement)을 사용하면 배열의 스캔을 매우 간단히 구현 O
 * 
 * 확장 for문의 장점
 * 		1. 배열의 요소수(길이)를 조사하는 수고를 덜 수 있다.
 * 		2. iterator와 같은 방법으로 스캔할 수 있다.
 * 
 * 배열의 모든 요소를 스캔하는 과정에서 index자체의 값이 필요하지 않으면,
 * 그 스캔은 확장 for문에 의해 구현하는 것이 좋다.
 * 
실행 결과 :  
	arr[0] = 1.0
	arr[1] = 2.0
	arr[2] = 3.0
	arr[3] = 4.0
	arr[4] = 5.0
	모든 요소의 합 : 15.0
 */

class page87_ArraySumForIn {
	public static void main(String[] args) {
		double[] arr = {1.0, 2.0, 3.0, 4.0, 5.0};
		
		for(int i=0; i<arr.length; i++) {
			System.out.println("arr["+i+"] = " +arr[i]);
		}
		
		double sum = 0;
		/*
		 *  ' : '은 ~의 안에 있는 이라는 의미
		 *  확장 for문을 for-in문 또는 for-each문이라고 부른다.
		 */
		for(double i : arr) {	//배열 arr의 처음부터 끝까지 모든 요소를 한 개씩 스캔하겠다. 현재 주목하고 있는 요소 = i
			sum += i;
		}
		/*
		for-each문을 기본for문으로 바꿔보기 
		for(int i=0; i<arr.length; i++){
			sum += arr[i];
		}
		*/
		System.out.println("모든 요소의 합 : "+sum);
	}
}