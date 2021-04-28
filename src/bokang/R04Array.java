package bokang;

import java.util.Scanner;

public class R04Array {

	public static void main(String[] args) {

		/*
		시나리오] 정수 10개를 저장할수 있는 배열을 생성한 후 
		반복문을 통해 1부터 순차적인 값을 입력하시오.
		 */
		int[] arr = new int[10];
		for(int i=0 ; i<arr.length ; i++) {
			arr[i] = i+1;
		}
		for(int i=0 ; i<arr.length ; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("\n\n");
		
		/*
		시나리오] 정수 5개를 저장할수 있는 배열을 생성한 후 숫자를 입력받아
		저장한다. 단 숫자가 짝수일때만 저장할수 있도록 프로그램을 작성하시오.
		 */
		Scanner scanner = new Scanner(System.in);
//		//배열을 생성하면 0으로 초기화된다.
//		int[] arr2 = new int[5];
//		//배열의 크기만큼 반복할때는 항상 length를 사용한다. 
//		for(int i=0 ; i<arr2.length ; i++) {
//			System.out.print("숫자를입력하세요:");
//			int input = scanner.nextInt();
//			
//			if(input%2==0) {
//				arr2[i] = input;
//			}
//		}
//		for(int i=0 ; i<arr2.length ; i++) {
//			System.out.print(arr2[i]+" ");
//		}
		
		/*
		시나리오] 정수 5개를 저장할수 있는 배열을 생성한 후 숫자를 입력받아
		저장한다. 단 숫자가 짝수일때만 순서대로 저장해야 하고, 5개 모두 입력되면
		프로그램을 종료한다. 
		 */
//		int[] arr3 = new int[5];
//		int index = 0;
//		while(true) {
//			System.out.print("숫자를입력하세요:");
//			int input2 = scanner.nextInt();			
//			if(input2%2==0) {
//				arr3[index++] = input2;
//			}
//			if(index==5) break;
//		}
//		for(int i=0 ; i<arr3.length ; i++) {
//			System.out.print(arr3[i]+" ");
//		}
		
		/*
		시나리오]1차원배열을 생성과 동시에 초기화하고 배열의 요소에
		중복값이 있는지 검사하는 프로그램을 작성하시오.
		중복이 없는경우에는 true, 중복이 있는경우에는 false를 반환한다.
		함수명 : arrayExistElements
		 */
		int[] arrNum1 = new int[] {1,2,3,4,5};
		int[] arrNum2 = {1,2,3,2,5};
		
		boolean isExist1 = arrayExistElements(arrNum1);
		boolean isExist2 = arrayExistElements(arrNum2);
		
		if(isExist1==true)
			System.out.println("arrNum1:중복없음");
		else
			System.out.println("arrNum1:중복있음");
		if(isExist2==true)
			System.out.println("arrNum2:중복없음");
		else
			System.out.println("arrNum2:중복있음");
		
		/*
		연습문제] 중복되지 않는 난수 6개를 생성하시오. 생성한 
		난수는 아래 배열에 채워넣은후 출력하시오.		
		 */
		int[] lottoNum = new int[6];
		//난수생성 및 중복검사
		randomCreate(lottoNum);
		//배열출력
		showArray(lottoNum);
	}
	public static void randomCreate(int[] arr) {
		//1.먼저 난수 6개를 생성한다. 임시배열에 저장한다. 
		
		//2.배열에 저장된 값이 중복되었는지 확인한다.(arrayExistElements()호출)
		
		//3.중복된 값이 만약 있다면 1번으로 돌아가서 다시 난수를 생성한다. 
		
		//4.중복된 값이 없다면 lottoNum배열에 채워준다.
	}
	public static void showArray(int[] arr) {
		//매개변수로 전달된 배열 arr을 출력한다.
	}
	public static boolean arrayExistElements(int[] arr) {
		
		for(int i=0 ; i<arr.length ; i++) {
			for(int j=0 ; j<arr.length ; j++) {
				if(i!=j) {//같은 인덱스끼리는 비교하지 않는다.
					if(arr[i]==arr[j]) {//만약 중복된 숫자가 확인되면
						return false;//즉시 false를 반환한다.
					}
				}
				else {
					System.out.println("같은 요소끼리는 비교불가");
				}
			}
		}
		
		return true;
	}
}






