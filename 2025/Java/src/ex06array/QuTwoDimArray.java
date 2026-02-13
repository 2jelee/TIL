package ex06array;
/*
이 메소드는 배열에 저장된 값을 add 만큼 증가시킨다.
이 메소드를 기반으로 int형 2차원 배열에 저장된 값을 증가시키는 
프로그램을 작성하시오. 단 2차원 배열의 가로, 세로길이에 상관없이 동작해야 하고, 
반드시 addOneArr() 메소드를 사용하여 구현해야 한다. 
그리고 증가되기전의 값과 증가되고난후의 값을 모두 출력해야 한다.
구현할 프로그램의 포맷은 다음과 같다. 
 */
public class QuTwoDimArray {

	//문제에서 제시한 내용
	public static void addOneArr(int[] arr, int add)
	{
		//가로에 대한 반복
		/*
		addTwoArr()에서 전달해준 인자는 2차원 배열의 한 행씩이므로
		해당 메소드에서는 1차원 배열의 형태로 접근 가능함. 
		 */
		for(int i=0; i<arr.length; i++){	
			arr[i] += add;
		}
	}
	//addOneArr() 메소드를 기반으로 2차원 배열을 증가시키는 메소드
	public static void addTwoArr(int[][] arr, int add)
	{
		/** 코드 삽입 **/
		/*
		2차원 배열의 세로길이만큼 반복하면서 한행씩 addOneArr()로 전달한다. 
		이차원배열에서는 배열의 이름을 통해 세로길이를 얻어올수 있다.
		 */
		for(int i=0 ; i<arr.length ; i++) {
			addOneArr(arr[i], add);
		}
	}
	
	public static void main(String[] args){		
		//배열선언
		int[][] arr = {
			{1, 2, 3, 4},
			{5, 6, 7},
			{8, 9}
		};
		//값 증가전 출력
		arrPrint(arr);		
		//2만큼 증가시키는 메소드 호출
		addTwoArr(arr, 2);
		//증가후 출력
		arrPrint(arr);
	}
	
	//2차원 배열을 출력하기 위한 메소드
	static void arrPrint(int[][] arr) {
		/** 코드 삽입 **/
		//세로 길이만큼 반복
		for(int i=0 ; i<arr.length ; i++) {
			//가로 길이만큼 반복
			for(int j=0 ; j<arr[i].length ; j++) {
				//각 요소를 출력
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();//한 행을 출력후 줄바꿈
		}
		//출력의 구분선
		System.out.println("==========================");
	}


}
